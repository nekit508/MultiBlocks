package сontent.bean;

import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.Wall;
import modClasses.MultiBlockInner;
import modClasses.MultiBlockOuter;

import static сontent.blocks.ModBlocks.*;

public class ModParts implements ContentList {
    @Override
    public void load() {
        beanInnerUp = new MultiBlockInner("bean-1"){{
            size = 1;
            health = 1;
            requirements(Category.crafting, ItemStack.with(Items.spore-pod, 1));
        }};
		beanInnerDown = new MultiBlockInner("bean-7"){{
            size = 1;
            health = 1;
            requirements(Category.crafting, ItemStack.with(Items.spore-pod, 1));
        }};
        beanOuter = new MultiBlockOuter("bean-3"){{
            size = 1;
            health = 1;
            requirements(Category.crafting, ItemStack.with(Items.spore-pod, 1));
        }};
    }
}
