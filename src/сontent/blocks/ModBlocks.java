package сontent.blocks;

import arc.util.Log;
import mindustry.ctype.ContentList;
import mindustry.world.Block;

public class ModBlocks implements ContentList {
    public static Block
            // defense
            leadWall,largeLeadWall,metaglassWall,largeMetaglassWall,siliconWall,largeSiliconWall,forceWall,magneticShield,
            // production
            // multi blocks
            multiSilicon,multiGraphite,multiMetaglass,multiPowerGenerator,
                    multiLiquid,multiReactor,oilFactory,
            // multi blocks's parts
            inner,outer,liquidOuter,liquidInner,battery,electricInterface;

    @Override
    public void load() {
        Log.info("Loading blocks");
        for (ContentList contentList : blocksContent) {
            contentList.load();
        }
    }

    private ContentList[] blocksContent = {
            new ModDefense(),
            new ModCrafting(),
            new ModPower(),
            new ModParts()
    };
}