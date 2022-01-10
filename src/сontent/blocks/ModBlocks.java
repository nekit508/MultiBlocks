package сontent.blocks;

import classes.blocks.MBParts.BaseMBPart;
import mindustry.ctype.ContentList;
import mindustry.world.Block;

public class ModBlocks implements ContentList {
    public static Block
            // multi-blocks
            MBT1Graphite,
            // multi-blocks tools
            itemIn, itemOut, liquidIn, liquidOut,
            // multi-block parts
            steelPanel, steelCoil, copperPanel, copperCoil,
            // not for use in game only for engine (don't delete!)
            upper
            ;

    @Override
    public void load() {
        upper = new BaseMBPart("upper"){{
            placeablePlayer = false;
        }};
        new MBT1s();
        new MBTools();
        new MBParts();
    }
}
