package сontent.constructions;

import classes.constructions.BaseConstruction;
import mindustry.content.Blocks;
import mindustry.world.Block;
import сontent.blocks.ModBlocks;

public class Constructions {
    public static BaseConstruction MBT1Graphite = new BaseConstruction(){{
        offset = 1;
        bluePrint = new Block[][]{
                {Blocks.copperWall, ModBlocks.itemOut, Blocks.copperWall,},
                {Blocks.copperWall, null,              Blocks.copperWall,},
                {ModBlocks.itemIn , Blocks.copperWall, Blocks.copperWall,}
        };
    }};
}
