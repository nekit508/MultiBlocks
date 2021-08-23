package сontent.bean;

import arc.util.Log;
import mindustry.ctype.ContentList;
import mindustry.world.Block;

public class ModBlocks implements ContentList {
    public static Block
            beanInnerUp,beanInnerDown,beanOuter,beanPart1,beanPart2,beanPart3,beanPart4,bigBean;

    @Override
    public void load() {
        Log.info("Loading blocks");
        for (ContentList contentList : blocksContent) {
            contentList.load();
        }
    }

    private ContentList[] blocksContent = {
            new ModCrafting(),
            new ModParts()
    };
}
