package movement_strategy;

public class MoveToBorder extends AbstractStrategy{
    @Override
    protected boolean IsTargetDestination() {
        var objParams = getObjectParameters.get();
        if(objParams == null)
            return false;
        return objParams.getRightBorder() + GetStep() >= getFieldWidth() &&
        objParams.getDownBorder() + GetStep() >= getFieldHeight();
    }
    @Override
    protected void MoveToTarget() {
        var objParams = getObjectParameters.get();
        if(objParams == null)
            return;
        var diffX = objParams.getRightBorder() - getFieldWidth();
        if (Math.abs(diffX) > GetStep())
            MoveRight();
        var diffY = objParams.getDownBorder() - getFieldHeight();
        if (Math.abs(diffY) > GetStep())
            MoveDown();
    }
}
