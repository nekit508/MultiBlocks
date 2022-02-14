package сontent.constructions;

import classes.constructions.BaseConstruction;
import mindustry.content.Blocks;
import mindustry.world.Block;
import mod.Reference;
import сontent.blocks.ModBlocks;

public class Constructions {
    public static BaseConstruction MBT1Steel;

    public static void init(){
        MBT1Steel = new BaseConstruction(){{
            offset = 2;
            bluePrint = new Block[][]{
                    {null, null, Blocks.copperWall, null, null},
                    {ModBlocks.itemIn, Blocks.copperWall, null, Blocks.copperWall, ModBlocks.itemOut},
                    {Blocks.copperWall , null, null, null, Blocks.copperWall},
                    {ModBlocks.itemIn, Blocks.copperWall, null, Blocks.copperWall,  ModBlocks.itemOut},
                    {null, null, Blocks.copperWall, null, null}
            };
        }};
    }
}
