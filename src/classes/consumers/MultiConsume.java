package classes.consumers;

import mindustry.gen.Building;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;

public class MultiConsume extends BaseConsume{
    @Override
    public boolean canConsume(Building build) {
        for(ItemStack stack: items){
            for(ItemStack stackOut: itemsOut) {
                if (stack.amount > build.items.get(stack.item) || stackOut.amount > build.block().itemCapacity - build.items.get(stackOut.item)) {
                    return false;
                }
            }
        }
        for(LiquidStack stack: liquids){
            for(LiquidStack stackOut: liquidsOut) {
                if (stack.amount > build.liquids.get(stack.liquid) - 0.001f ||
                        stackOut.amount > build.block().liquidCapacity - build.liquids.get(stackOut.liquid) - 0.001f) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void consume(Building build) {
        for(ItemStack stack: items){
            build.items.remove(stack);
        }
        for(LiquidStack stack: liquids){
            build.liquids.remove(stack.liquid, stack.amount);
        }

        for(ItemStack stack: itemsOut){
            build.items.add(stack.item, stack.amount);
        }
        for(LiquidStack stack: liquidsOut){
            build.liquids.add(stack.liquid, stack.amount);
        }
    }
}
