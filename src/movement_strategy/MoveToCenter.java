package movement_strategy;

public class MoveToCenter extends AbstractStrategy{
    @Override
    protected boolean IsTargetDestination() {
        var objParams = getObjectParameters.get();
        if(objParams == null)
            return false;

        return objParams.getObjectMiddleHorizontal() <= getFieldWidth() / 2 &&
        objParams.getObjectMiddleHorizontal()+GetStep() >= getFieldWidth() / 2 &&
        objParams.getObjectMiddleVertical() <= getFieldHeight() / 2 &&
        objParams.getObjectMiddleVertical() + GetStep() >= getFieldHeight() / 2;
    }
    @Override
    protected void MoveToTarget() {
        var objParams = getObjectParameters.get();
        if(objParams == null)
            return;
        var diffX = objParams.getObjectMiddleHorizontal() - getFieldWidth() / 2;
        if(Math.abs(diffX) > GetStep()){
            if(diffX > 0)
                MoveLeft();
            else
                MoveRight();
        }
        var diffY = objParams.getObjectMiddleVertical() - getFieldHeight() / 2;
        if(Math.abs(diffY) > GetStep()){
            if(diffY > 0)
                MoveUp();
            else
                MoveDown();
        }
    }
}
