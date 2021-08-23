package сontent.bean;

import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.defense.Wall;
import modClasses.*;
import modVars.Constructions;
import сontent.bean.beanItems;

import static сontent.bean.ModBeans.*;

public class ModCrafting implements ContentList {
    @Override
    public void load() {
        bigBean = new MultiBlockCenter("bean-4"){{
            construction = Constructions.beanFactory;
            size = 1;
            health = 1;
            hasItems = true;
            requirements(Category.crafting, ItemStack.with(Items.sporePod, 1));
            consItems = ItemStack.with(Items.sporePod, 1, Items.silicon, 5);
            consumes.power(10000);
            consumes.items(ItemStack.with(Items.sporePod, 1, Items.silicon, 5));
            outputItem = new ItemStack(Items.FaSolka, 1);
        }};
    }
}
