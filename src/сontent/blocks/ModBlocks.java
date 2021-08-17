package сontent.blocks;

import mindustry.ctype.ContentList;
import mindustry.world.Block;

public class ModBlocks implements ContentList {
    public static Block
            // defense
            leadWall,largeLeadWall,metaglassWall,largeMetaglassWall,siliconWall,largeSiliconWall,forceWall,magneticShield,batteryWall,electroInterfaceWall,
            // production
            // multi blocks
            multiSilicon,inner,outer,liquidOuter,liquidInner,multiGraphite,multiMetaglass,multiPowerGenerator,multiLiquid,multiReactor;

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