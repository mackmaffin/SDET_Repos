package movement_strategy;

public class ObjectParameters {
    private final int POS_X;
    private final int POS_Y;
    private final int WIDTH;
    private final int HEIGHT;
    public int getLeftBorder() {return POS_X;}
    public int getTopBorder() {return POS_Y;}
    public int getRightBorder() {return POS_X + WIDTH;}
    public int getDownBorder() {return POS_Y + HEIGHT;}
    public int getObjectMiddleHorizontal() {return POS_X + this.WIDTH / 2;}
    public int getObjectMiddleVertical() {return POS_Y + this.HEIGHT / 2;}
    public ObjectParameters(int x, int y, int width, int height)
    {
        POS_X = x;
        POS_Y = y;
        WIDTH = width;
        HEIGHT = height;
    }
}
