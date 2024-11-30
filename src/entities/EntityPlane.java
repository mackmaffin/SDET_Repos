package entities;

import java.awt.*;
import java.util.function.Supplier;
public class EntityPlane {
    private int speed;
    public int getSpeed() {
        return speed;
    }
    private double weight;
    public double getWeight() {
        return weight;
    }
    private Color bodyColor;
    public Color getBodyColor() {
        return bodyColor;
    }
    public Supplier<Double> step = () -> (double) speed * 100 / weight;
    public EntityPlane(int speed, double weight, Color bodyColor){
        this.speed = speed;
        this.weight = weight;
        this.bodyColor = bodyColor;
    }
}
