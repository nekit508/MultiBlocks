package classes.constructions;

import arc.graphics.g2d.Draw;
import arc.util.Log;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.graphics.Layer;
import mindustry.world.Block;
import mod.Tools;

public class BaseConstruction {
    public Block[][] bluePrint;
    public int offset;

    public BaseConstruction(){}

    public boolean check(Building center){
        Block block;
        Block bluePrintBlock;
        for(int x = 0;x < bluePrint.length;x++){
            for(int y = 0;y < bluePrint[x].length;y++){
                block = null;
                bluePrintBlock = bluePrint[x][y];
                Building building = Vars.world.build(x - offset + center.tileX(), y - offset + center.tileY());
                if(building != null) {
                    block = building.block;
                }
                if(bluePrintBlock != block && bluePrintBlock != null) return false;
            }
        }
        return true;
    }

    public void drawBluePrint(Building center){
        Block bluePrintBlock;
        int xPos, yPos;
        Draw.alpha(0.6f);
        Draw.z(Layer.block);
        for(int x = 0;x < bluePrint.length;x++){
            for(int y = 0;y < bluePrint[x].length;y++){
                bluePrintBlock = bluePrint[x][y];
                xPos = center.tileX() + x - offset;
                yPos = center.tileY() + y - offset;
                if(bluePrintBlock != null) Tools.drawBlock(bluePrintBlock, xPos, yPos);
            }
        }
        Draw.reset();
    }
}
