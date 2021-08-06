package сontent.blocks;

import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import modClasses.MultiBlockCenter;
import modClasses.MultiBlockInner;
import modClasses.MultiBlockOuter;
import modVars.Constructions;

import static сontent.blocks.ModBlocks.*;

public class ModCrafting implements ContentList {
    @Override
    public void load() {
        multiSilicon = new MultiBlockCenter("multi-block-silicon"){{
            construction = Constructions.siliconFactory;
            size = 1;
            health = 100;
            requirements(Category.crafting, ItemStack.with(Items.lead, 32));
            consumes.power(2);
            consumes.items(ItemStack.with(Items.coal, 1, Items.sand, 2));
            outputItem = new ItemStack(Items.silicon, 2);
        }};
        inner = new MultiBlockInner("multi-block-inner"){{
            size = 1;
            health = 100;
            requirements(Category.crafting, ItemStack.with(Items.lead, 32));
        }};
        outer = new MultiBlockOuter("multi-block-outer"){{
            size = 1;
            health = 100;
            requirements(Category.crafting, ItemStack.with(Items.lead, 32));
        }};
        multiGraphite = new MultiBlockCenter("multi-block-graphite"){{
            construction = Constructions.siliconFactory;
            size = 1;
            health = 100;
            requirements(Category.crafting, ItemStack.with(Items.lead, 32));
            consumes.power(2);
            consumes.items(ItemStack.with(Items.coal, 1, Items.sand, 2));
            outputItem = new ItemStack(Items.silicon, 2);
        }};
    }
}