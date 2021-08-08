package сontent.blocks;

import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.power.PowerGenerator;
import modClasses.MultiBlockPowerCenter;

import static modVars.Constructions.solidFuelGenerator;
import static сontent.blocks.ModBlocks.*;

public class ModPower implements ContentList {
    @Override
    public void load() {
        multiPowerGenerator = new MultiBlockPowerCenter("multi-block-solid-fuel-generator"){{
            health = 100;
            requirements(Category.power,ItemStack.with(Items.lead, 100));
            powerProduction = 20f;
            construction = solidFuelGenerator;
            consumes.items(ItemStack.with(Items.pyratite, 1));
        }};
    }
}