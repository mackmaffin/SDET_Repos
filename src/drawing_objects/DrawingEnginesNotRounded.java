package drawing_objects;

import enums.*;
import java.awt.*;

public class DrawingEnginesNotRounded implements IDrawEngines{
    private EngineNumber number;
    public void setNumber(int x){
        if(x <= 2)
            number = EngineNumber.TWO;
        if(x == 4)
            number = EngineNumber.FOUR;
        if(x >= 6)
            number = EngineNumber.SIX;
    }
    public void drawEngines(Graphics2D graphics2D, int _startX, int _startY){
        graphics2D.fillRect(_startX+70, _startY+20, 20, 15);
        graphics2D.fillRect(_startX+70, _startY+125, 20, 15);
        if (number == EngineNumber.FOUR || number == EngineNumber.SIX){
            graphics2D.fillRect(_startX+70, _startY+40, 20, 15);
            graphics2D.fillRect(_startX+70, _startY+105, 20, 15);
        }
        if (number == EngineNumber.SIX){
            graphics2D.fillRect(_startX+130, _startY+50, 25, 15);
            graphics2D.fillRect(_startX+130, _startY+95, 25, 15);
        }
    }
}