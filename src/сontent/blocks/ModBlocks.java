package сontent.blocks;

import mindustry.ctype.ContentList;
import mindustry.world.Block;

public class ModBlocks implements ContentList {
    public static Block
            MBT1Graphite, itemIn, itemOut, liquidIn, liquidOut;

    @Override
    public void load() {
        new MBT1s();
        new MBTools();
    }
}
