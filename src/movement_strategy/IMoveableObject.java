package movement_strategy;
import enums.DirectionType;
public interface IMoveableObject {
    ObjectParameters getObjectPosition();
    int getStep();
    boolean checkCanMove(DirectionType direction);
    void moveObject(DirectionType direction);
}
