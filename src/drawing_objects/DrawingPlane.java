package drawing_objects;

import entities.EntityPlane;
import enums.*;

import java.awt.*;

public class DrawingPlane {
    protected EntityPlane entityPlane;
    protected void setEntityPlane(EntityPlane entityPlane){this.entityPlane = entityPlane;}
    public EntityPlane getEntityPlane() {
        return entityPlane;
    }
    private IDrawEngines drawingEngines;
    private int pictureWidth;
    private int pictureHeight;
    protected int startPosX;
    public int getPosX(){return startPosX;}
    protected int startPosY;
    public int getPosY(){return startPosY;}
    private final int PLANE_WIDTH = 160;
    public int getWidth(){return PLANE_WIDTH;}
    private final int PLANE_HEIGHT = 160;
    public int getHeight(){return PLANE_HEIGHT;}
    public DrawingPlane(int speed, double weight, Color bodyColor, int width, int height, int enginesType, int enginesNumber) {
        if (width < PLANE_WIDTH || height < PLANE_HEIGHT)
            return;
        pictureWidth = width;
        pictureHeight = height;
        entityPlane = new EntityPlane(speed, weight, bodyColor);
        switch (enginesType){
            case 1:
                drawingEngines = new DrawingEnginesNotRounded();
                break;
            case 2:
                drawingEngines = new DrawingEnginesRoundedFront();
                break;
            default:
                drawingEngines = new DrawingEnginesRoundedBack();
                break;
        }
        drawingEngines.setNumber(enginesNumber);
    }
    public void setPosition(int x, int y) {
        if (x < 0 || y < 0 || x + PLANE_WIDTH > pictureWidth || y + PLANE_HEIGHT > pictureHeight)
            x = y = 0;
        startPosX = x;
        startPosY = y;
    }
    public void drawTransport(Graphics2D g) {
        if (entityPlane == null)
            return;
        BasicStroke pen = new BasicStroke(2);
        Color penColor = Color.BLACK;
        Color bodyColor = entityPlane.getBodyColor();
        g.setStroke(pen);
        g.setColor(bodyColor);
        //фюзеляж
        g.fillRect(startPosX + 20, startPosY + 70, 140, 20);
        //кабина
        int[] pointX = new int[]{startPosX, startPosX + 20, startPosX + 20};
        int[] pointY = new int[]{startPosY + 80, startPosY + 70, startPosY + 90};
        g.setColor(Color.BLUE);
        g.fillPolygon(pointX, pointY, 3);
        //границы самолета
        g.setColor(penColor);
        g.drawPolygon(pointX, pointY, 3);
        g.drawRect(startPosX + 20, startPosY + 70, 140, 20);
        //Крылья
        pointX = new int[]{startPosX + 70, startPosX + 70, startPosX + 90, startPosX + 100};
        pointY = new int[]{startPosY + 70, startPosY, startPosY, startPosY + 70};
        g.setColor(bodyColor);
        g.fillPolygon(pointX, pointY, 4);
        g.setColor(penColor);
        g.drawPolygon(pointX, pointY, 4);
        pointX = new int[]{startPosX + 70, startPosX + 70, startPosX + 90, startPosX + 100};
        pointY = new int[]{startPosY + 90, startPosY + 160, startPosY + 160, startPosY + 90};
        g.setColor(bodyColor);
        g.fillPolygon(pointX, pointY, 4);
        g.setColor(penColor);
        g.drawPolygon(pointX, pointY, 4);
        pointX = new int[]{startPosX + 130, startPosX + 130, startPosX + 160, startPosX + 160};
        pointY = new int[]{startPosY + 70, startPosY + 50, startPosY + 30, startPosY + 70};
        g.setColor(bodyColor);
        g.fillPolygon(pointX, pointY, 4);
        g.setColor(penColor);
        g.drawPolygon(pointX, pointY, 4);
        pointX = new int[]{startPosX + 130, startPosX + 130, startPosX + 160, startPosX + 160};
        pointY = new int[]{startPosY + 90, startPosY + 110, startPosY + 130, startPosY + 90};
        g.setColor(bodyColor);
        g.fillPolygon(pointX, pointY, 4);
        g.setColor(penColor);
        g.drawPolygon(pointX, pointY, 4);
        //двигатели
        drawingEngines.drawEngines(g, startPosX, startPosY);
    }
    public boolean canMove(DirectionType direction) {
        if (entityPlane == null) {
            return false;
        }
        switch(direction) {
            case LEFT:
                return startPosX - entityPlane.step.get().intValue() > 0;
            case UP:
                return startPosY - entityPlane.step.get().intValue() > 0;
            case RIGHT:
                return startPosX + entityPlane.step.get().intValue() + PLANE_WIDTH < pictureWidth;
            case DOWN:
                return startPosY + entityPlane.step.get().intValue() + PLANE_WIDTH < pictureHeight;
            default:
                return false;
        }
    }
    public void moveTransport(DirectionType direction)
    {
        if (!canMove(direction) || entityPlane == null)
            return;
        switch (direction)
        {
            //влево
            case LEFT:
                startPosX -= entityPlane.step.get().intValue();
                break;
            //вверх
            case UP:
                startPosY -= entityPlane.step.get().intValue();
                break;
            // вправо
            case RIGHT:
                startPosX += entityPlane.step.get().intValue();
                break;
            //вниз
            case DOWN:
                startPosY += entityPlane.step.get().intValue();
                break;
        }
    }
}
