package drawing_objects;

import entities.*;

import java.awt.*;

public class DrawingAirBomber extends DrawingPlane {

    public DrawingAirBomber(int speed, double weight, Color bodyColor,
        Color additionalColor, boolean bombs, boolean fuel, int width, int height, int enginesType, int enginesNumber){
        super(speed, weight, bodyColor, width, height, enginesType, enginesNumber);
        if(entityPlane != null)
            entityPlane = new EntityAirBomber(speed, weight, bodyColor, additionalColor,bombs, fuel);
    }

    public void drawTransport(Graphics2D g)
    {
        if (!(entityPlane instanceof EntityAirBomber))
            return;
        EntityAirBomber entityAirBomber = (EntityAirBomber) entityPlane;
        BasicStroke pen = new BasicStroke(2);
        Color penColor = Color.BLACK;
        Color additionalColor = entityAirBomber.getAdditionalColor();
        g.setStroke(pen);
        super.drawTransport(g);
        // топливо
        if (entityAirBomber.getFuel())
        {
            g.setColor(additionalColor);
            g.fillOval(this.startPosX + 60, this.startPosY - 1, 40, 10);
            g.fillOval(this.startPosX + 60, this.startPosY + 150, 40, 10);
            g.setColor(penColor);
            g.drawOval(startPosX + 60, startPosY - 1, 40, 10);
            g.drawOval(startPosX + 60, startPosY + 150, 40, 10);
        }
        //бомбы
        if (entityAirBomber.getBombs())
        {
            int[] pointX = new int[]{startPosX+50, startPosX+70, startPosX+80, startPosX+90, startPosX+90, startPosX+80, startPosX+70, startPosX+50};
            int[] pointY = new int[]{startPosY+75, startPosY+75, startPosY+80, startPosY+75, startPosY+85, startPosY+80, startPosY+85, startPosY+85};
            g.setColor(additionalColor);
            g.fillPolygon(pointX, pointY, 8);
            g.setColor(penColor);
            g.drawPolygon(pointX, pointY, 8);
            pointX = new int[]{startPosX+100, startPosX+120, startPosX+130, startPosX+140, startPosX+140, startPosX+130, startPosX+120, startPosX+100};
            pointY = new int[]{startPosY+75, startPosY+75, startPosY+80, startPosY+75, startPosY+85, startPosY+80, startPosY+85, startPosY+85};
            g.setColor(additionalColor);
            g.fillPolygon(pointX, pointY, 8);
            g.setColor(penColor);
            g.drawPolygon(pointX, pointY,8);
        }
    }
}