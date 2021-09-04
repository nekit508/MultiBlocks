package сontent.blocks;

import arc.util.Log;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;
import modClasses.ShaderBlock;

public class ModBlocks implements ContentList {
    public static Block
            // test
            shaderTest,
            // defense
            leadWall,largeLeadWall,metaglassWall,largeMetaglassWall,siliconWall,largeSiliconWall,copperCoil,
			// forceWall,magneticShield,
            // production
            // multi blocks
            multiSilicon,multiGraphite,multiMetaglass,multiPowerGenerator,multiLiquid,multiReactor,oilFactory,
            // multi blocks's parts
            battery,electricInterface,compressor,mega-compressor,
			//inners and outers
			liquidOuter,liquidInner,inner,outer,mediumInner,mediumOuter,largeInner,largeOuter;
            //bean
	        //beanInnerUp,beanInnerDown,beanOuter,beanPart1,beanPart2,beanPart3,beanPart4,multiBigBean;
			
    @Override
    public void load() {
        Log.info("Loading blocks");
        for (ContentList contentList : blocksContent) {
            contentList.load();
        }

        Log.info("Loading shader block");
        shaderTest = new ShaderBlock("shader-block"){{
            solid = true;
            health = 500;
            size = 2;
            requirements(Category.effect, BuildVisibility.sandboxOnly, ItemStack.with(Items.lead, 8));
        }};
    }

    private final ContentList[] blocksContent = {
            new ModDefense(),
            new ModCrafting(),
            new ModPower(),
            new ModParts()
    };
}
