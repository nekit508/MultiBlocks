package сontent.bean;

import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.Wall;
import modClasses.MultiBlockInner;
import modClasses.MultiBlockOuter;

import static сontent.bean.ModBeans.*;

public class ModParts implements ContentList {
    @Override
    public void load() {
        beanInnerUp = new MultiBlockInner("bean-1"){{
            size = 1;
            health = 1;
            requirements(Category.crafting, ItemStack.with(Items.sporePod, 1));
        }};
		beanInnerDown = new MultiBlockInner("bean-7"){{
            size = 1;
            health = 1;
            requirements(Category.crafting, ItemStack.with(Items.sporePod, 1));
        }};
        beanOuter = new MultiBlockOuter("bean-3"){{
            size = 1;
            health = 1;
            requirements(Category.crafting, ItemStack.with(Items.sporePod, 1));
        }};
		beanPart1 = new Wall("bean-2"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.sporePod, 1));
        }};
        beanPart2 = new Wall("bean-5"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.sporePod, 1));
        }};
        beanPart3 = new Wall("bean-6"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.sporePod, 1));
        }};
        beanPart4 = new Wall("bean-8"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.sporePod, 1));
        }};
    }
}