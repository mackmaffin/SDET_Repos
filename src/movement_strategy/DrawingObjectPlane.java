package movement_strategy;

import drawing_objects.DrawingPlane;
import enums.DirectionType;

public class DrawingObjectPlane implements IMoveableObject{
    private final DrawingPlane drawingPlane;
    public DrawingObjectPlane(DrawingPlane drawingPlane){
        this.drawingPlane = drawingPlane;
    }
    public ObjectParameters getObjectPosition(){
        if(drawingPlane == null || drawingPlane.getEntityPlane() == null)
            return null;
        return new ObjectParameters(drawingPlane.getPosX(), drawingPlane.getPosY(),
                drawingPlane.getWidth(), drawingPlane.getHeight());
    }
    public int getStep(){
        if(drawingPlane.getEntityPlane() == null)
            return 0;
        return drawingPlane.getEntityPlane().step.get().intValue();
    }
    public boolean checkCanMove(DirectionType direction){
        if(drawingPlane == null)
            return false;
        return drawingPlane.canMove(direction);
    }
    public void moveObject(DirectionType direction){
        drawingPlane.moveTransport(direction);
    }
}
