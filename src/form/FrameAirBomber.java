package form;

import drawing_objects.DrawingAirBomber;
import drawing_objects.DrawingPlane;
import enums.*;
import movement_strategy.*;
import movement_strategy.DrawingObjectPlane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;
public class FrameAirBomber extends JFrame {
    private DrawingPlane drawingPlane;
    private AbstractStrategy abstractStrategy;
    private JComboBox comboBoxStrategy;
    private final JComponent pictureBox;
    public FrameAirBomber() throws IOException {
        super("Бомбардировщик");
        setSize(new Dimension(900,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //components initialisation
        pictureBox = new JComponent(){
            public void paintComponent(Graphics graphics){
                super.paintComponent(graphics);
                Graphics2D graphics2D = (Graphics2D) graphics;
                if (drawingPlane != null) drawingPlane.drawTransport(graphics2D);
                super.repaint();
            }
        };
        comboBoxStrategy = new JComboBox<>(new String[]{"К центру", "К границе"});
        JButton stepButton = new JButton("Шаг");
        JButton createPlaneButton = new JButton("Создать самолет");
        JButton createAirBomberButton = new JButton("Создать бомбардировщик");
        JButton rightButton = new JButton(new ImageIcon(ImageIO.read(new File("images/right.png"))));
        JButton leftButton = new JButton(new ImageIcon(ImageIO.read(new File("images/left.png"))));
        JButton upButton = new JButton(new ImageIcon(ImageIO.read(new File("images/up.png"))));
        JButton downButton = new JButton(new ImageIcon(ImageIO.read(new File("images/down.png"))));
        pictureBox.setBounds( 0, 0, getContentPane().getWidth(), getContentPane().getHeight());
        //ActionListeners and ActionCommand addition
        createPlaneButton.addActionListener(e -> buttonCreatePlaneClick());
        createAirBomberButton.addActionListener(e -> buttonCreateAirBomberClick());
        stepButton.addActionListener(e -> buttonStepClick());
        rightButton.setActionCommand("right");
        rightButton.addActionListener(this::buttonMoveClick);
        leftButton.setActionCommand("left");
        leftButton.addActionListener(this::buttonMoveClick);
        upButton.setActionCommand("up");
        upButton.addActionListener(this::buttonMoveClick);
        downButton.setActionCommand("down");
        downButton.addActionListener(this::buttonMoveClick);
        //component addition
        setLayout(new BorderLayout());
        JPanel panelAirBomber = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());
        JPanel leftPanel = new JPanel(new BorderLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets.left = constraints.insets.top = constraints.insets.bottom = constraints.insets.right = 2;
        //createPanel
        JPanel createPanel = new JPanel(new GridBagLayout());
        constraints.gridx = 0;
        constraints.gridy = 0;
        createPanel.add(createPlaneButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        createPanel.add(createAirBomberButton, constraints);
        //movementPanel
        JPanel movementPanel = new JPanel(new GridBagLayout());
        rightButton.setPreferredSize(new Dimension(30,30));
        constraints.gridx = 2;
        constraints.gridy = 1;
        movementPanel.add(rightButton, constraints);
        leftButton.setPreferredSize(new Dimension(30,30));
        constraints.gridx = 0;
        constraints.gridy = 1;
        movementPanel.add(leftButton, constraints);
        upButton.setPreferredSize(new Dimension(30,30));
        constraints.gridx = 1;
        constraints.gridy = 0;
        movementPanel.add(upButton, constraints);
        downButton.setPreferredSize(new Dimension(30,30));
        constraints.gridx = 1;
        constraints.gridy = 1;
        movementPanel.add(downButton, constraints);
        //stepPanel
        JPanel stepPanel = new JPanel(new GridBagLayout());
        constraints.gridx = 0;
        constraints.gridy = 0;
        stepPanel.add(comboBoxStrategy, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        stepPanel.add(stepButton, constraints);
        //addition to frame
        add(pictureBox);
        rightPanel.add(movementPanel, BorderLayout.SOUTH);
        rightPanel.add(stepPanel, BorderLayout.NORTH);
        leftPanel.add(createPanel, BorderLayout.SOUTH);
        panelAirBomber.add(rightPanel, BorderLayout.EAST);
        panelAirBomber.add(leftPanel, BorderLayout.WEST);
        add(panelAirBomber,BorderLayout.CENTER);
        setVisible(true);
    }
    private void buttonCreateAirBomberClick() {
        Random random = new Random();
        pictureBox.setBounds(0,0,getContentPane().getWidth(),getContentPane().getHeight());
        drawingPlane = new DrawingAirBomber(random.nextInt(200) + 100, random.nextInt(2000) + 1000, new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)),
                new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), random.nextBoolean(), random.nextBoolean(), pictureBox.getWidth(), pictureBox.getHeight(), random.nextInt(3),(random.nextInt(3)+1)*2);
        drawingPlane.setPosition(random.nextInt(90) + 10, random.nextInt(90) + 10);
        draw();
    }
    private void buttonCreatePlaneClick(){
        Random random = new Random();
        pictureBox.setBounds(0,0,getContentPane().getWidth(),getContentPane().getHeight());
        drawingPlane = new DrawingPlane(random.nextInt(200) + 100, random.nextInt(2000) + 1000, new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)),
                pictureBox.getWidth(), pictureBox.getHeight(), random.nextInt(3),(random.nextInt(3)+1)*2);
        drawingPlane.setPosition(random.nextInt(90) + 10, random.nextInt(90) + 10);
        draw();
    }
    private void buttonStepClick(){
        if (drawingPlane == null) {
            return;
        }
        if (comboBoxStrategy.isEnabled()) {
            ;
            switch(comboBoxStrategy.getSelectedIndex()) {
                case 0:
                    abstractStrategy = new MoveToCenter();
                    break;
                case 1:
                    abstractStrategy = new MoveToBorder();
                    break;
                default:
                    abstractStrategy = null;
                    break;
            };
            if (abstractStrategy == null)
            {
                return;
            }
            abstractStrategy.SetData(new DrawingObjectPlane(drawingPlane), pictureBox.getWidth(),
                    pictureBox.getHeight());
            comboBoxStrategy.setEnabled(false);
        }
        if (abstractStrategy == null)
        {
            return;
        }
        abstractStrategy.MakeStep();
        draw();
        if (abstractStrategy.GetStatus() == Status.FINISH)
        {
            comboBoxStrategy.setEnabled(true);
            abstractStrategy = null;
        }
    }
    private void buttonMoveClick(ActionEvent event) {
        if(drawingPlane == null || drawingPlane.getEntityPlane() == null)
            return;
        switch (event.getActionCommand())
        {
            case "left":
                drawingPlane.moveTransport(DirectionType.LEFT);
                break;
            case "right":
                drawingPlane.moveTransport(DirectionType.RIGHT);
                break;
            case "up":
                drawingPlane.moveTransport(DirectionType.UP);
                break;
            case "down":
                drawingPlane.moveTransport(DirectionType.DOWN);
                break;
        }
        draw();
    }
    private void draw() {
        if (drawingPlane == null)
            return;
        pictureBox.repaint();
    }
}