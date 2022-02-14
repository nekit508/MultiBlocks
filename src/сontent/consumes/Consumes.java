package сontent.consumes;

import classes.consumers.BaseConsume;
import classes.consumers.MultiConsume;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import сontent.items.ModItems;

public class Consumes {
    public static BaseConsume Steel = new MultiConsume(){{
        items = new ItemStack[]{new ItemStack(Items.lead, 1), new ItemStack(Items.coal, 3)};
        itemsOut = new ItemStack[]{new ItemStack(ModItems.steel, 1)};
    }};
}
