package сontent.blocks;

import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.Wall;
import modClasses.MultiBlockInner;
import modClasses.MultiBlockLiquidInner;
import modClasses.MultiBlockLiquidOuter;
import modClasses.MultiBlockOuter;

import static сontent.blocks.ModBlocks.*;

public class ModParts implements ContentList {
    @Override
    public void load() {
        battery = new Wall("battery"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 15;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.copper, 50, Items.lead, 100));
        }};
        electricInterface = new Wall("electric-interface"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 15;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.copper, 50, Items.titanium, 50));
        }};
        inner = new MultiBlockInner("multi-block-inner"){{
            size = 1;
            health = 15;
            requirements(Category.crafting, ItemStack.with(Items.thorium, 50));
        }};
        outer = new MultiBlockOuter("multi-block-outer"){{
            size = 1;
            health = 15;
            requirements(Category.crafting, ItemStack.with(Items.thorium, 50));
        }};
        liquidInner = new MultiBlockLiquidInner("multi-block-liquid-inner"){{
            size = 1;
            health = 15;
            requirements(Category.crafting, ItemStack.with(Items.plastanium, 20, Items.titanium, 30));
        }};
        liquidOuter = new MultiBlockLiquidOuter("multi-block-liquid-outer"){{
            size = 1;
            health = 15;
            requirements(Category.crafting, ItemStack.with(Items.phaseFabric, 20, Items.titanium, 30));
        }};
	/*
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
	*/
    }
}
