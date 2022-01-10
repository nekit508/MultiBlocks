package сontent.consumes;

import classes.consumers.BaseConsume;
import classes.consumers.MultiConsume;
import mindustry.content.Items;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;

public class Consumes {
    public static BaseConsume CoalToGraphite = new MultiConsume(){{
        items = new ItemStack[]{new ItemStack(Items.coal, 2)};
        liquids = new LiquidStack[]{};
        itemsOut = new ItemStack[]{new ItemStack(Items.graphite, 1)};
    }};
}
