package сontent.blocks;

import arc.util.Log;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;

public class ModBlocks implements ContentList {
    public static Block block;
			
    @Override
    public void load() {
        for (ContentList contentList : blocksContent) {
            contentList.load();
        }
    }

    private final ContentList[] blocksContent = {

    };
}
