package classes.consumers;

import mindustry.gen.Building;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;

public class BaseConsume {
    public ItemStack[] items = new ItemStack[]{}, itemsOut = new ItemStack[]{};
    public LiquidStack[] liquids = new LiquidStack[]{}, liquidsOut = new LiquidStack[]{};
    public boolean canConsume(Building build){return false;}
    public void consume(Building build){}
}
