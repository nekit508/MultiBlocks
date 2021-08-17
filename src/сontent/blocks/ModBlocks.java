package сontent.blocks;

import mindustry.ctype.ContentList;
import mindustry.world.Block;

public class ModBlocks implements ContentList {
    public static Block
            // defense
            leadWall,largeLeadWall,metaglassWall,largeMetaglassWall,siliconWall,largeSiliconWall,forceWall,magneticShield,
            // production
            // multi blocks
            multiSilicon,inner,outer,liquidOuter,liquidInner,electricInterface,multiGraphite,multiMetaglass,multiPowerGenerator,
                    multiLiquid,multiReactor,battery,electroInterface;

    @Override
    public void load() {
        for (ContentList contentList : blocksContent) {
            contentList.load();
        }
    }

    private ContentList[] blocksContent = {
            new ModDefense(),
            new ModCrafting(),
            new ModPower()
    };
}