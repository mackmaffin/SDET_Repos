package entities;

import java.awt.*;

public class EntityAirBomber extends EntityPlane {
    private Color additionalColor;
    public Color getAdditionalColor(){
        return additionalColor;
    }
    private boolean isFuel;
    public boolean getFuel() {
        return isFuel;
    }
    private boolean isBombs;
    public boolean getBombs() {
        return isBombs;
    }
    public EntityAirBomber(int speed, double weight, Color bodyColor, Color
            additionalColor, boolean isBombs, boolean isFuel) {
        super(speed, weight, bodyColor);
        this.additionalColor = additionalColor;
        this.isFuel = isFuel;
        this.isBombs = isBombs;
    }
}