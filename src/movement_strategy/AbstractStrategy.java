package movement_strategy;
import enums.DirectionType;
import enums.Status;

import java.util.function.Supplier;
public abstract class AbstractStrategy {
    private IMoveableObject moveableObject;
    private Status state = Status.NOTINIT;
    private int FieldWidth;
    protected int getFieldWidth(){return FieldWidth;}
    private int FieldHeight;
    protected int getFieldHeight(){return FieldHeight;}
    public Status GetStatus() {return state;}

    public void SetData(IMoveableObject moveableObject, int width, int height){
        if(moveableObject == null){
            state = Status.NOTINIT;
            return;
        }
        state = Status.INPROGRESS;
        this.moveableObject = moveableObject;
        FieldWidth = width;
        FieldHeight = height;
    }

    public void MakeStep(){
        if(state != Status.INPROGRESS)
            return;
        if(IsTargetDestination()){
            state = Status.FINISH;
            return;
        }
        MoveToTarget();
    }

    protected boolean MoveLeft() {return MoveTo(DirectionType.LEFT);}
    protected boolean  MoveRight() {return MoveTo(DirectionType.RIGHT);}
    protected boolean MoveUp() {return MoveTo(DirectionType.UP);}
    protected boolean MoveDown() {return MoveTo(DirectionType.DOWN);}
    protected Supplier<ObjectParameters> getObjectParameters = () -> moveableObject.getObjectPosition();

    protected Integer GetStep(){
        if(state != Status.INPROGRESS)
            return null;
        return moveableObject.getStep();
    }

    protected abstract void MoveToTarget();
    protected abstract boolean IsTargetDestination();

    private boolean MoveTo(DirectionType direction){
        if(state != Status.INPROGRESS)
            return false;
        if(moveableObject.checkCanMove(direction)){
            moveableObject.moveObject(direction);
            return true;
        }
        return false;
    }
}
