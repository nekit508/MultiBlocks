package сontent.blocks;
import classes.blocks.MBsTools.MBItemPort;
import classes.blocks.MBsTools.MBLiquidPort;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;

public class MBTools{
    public MBTools(){
        ModBlocks.itemIn = new MBItemPort("items-in") {{
            mode = true;
            health = 250;
            itemCapacity = 10;
            requirements(Category.distribution, ItemStack.with(Items.copper, 10));
        }};
        ModBlocks.itemOut = new MBItemPort("items-out") {{
            mode = false;
            health = 250;
            itemCapacity = 10;
            requirements(Category.distribution, ItemStack.with(Items.copper, 10));
        }};
        ModBlocks.liquidIn = new MBLiquidPort("liquids-in") {{
            mode = true;
            health = 250;
            itemCapacity = 10;
            requirements(Category.distribution, ItemStack.with(Items.copper, 10));
        }};
        ModBlocks.liquidOut = new MBLiquidPort("liquids-out") {{
            mode = false;
            size = 1;
            health = 250;
            itemCapacity = 10;
            requirements(Category.distribution, ItemStack.with(Items.copper, 10));
        }};
    }
}
