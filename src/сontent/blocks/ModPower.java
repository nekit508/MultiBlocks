package сontent.blocks;

import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import modClasses.MultiBlockCenter;

import static modVars.Constructions.solidFuelGenerator;
import static сontent.blocks.ModBlocks.*;

public class ModPower implements ContentList {
    @Override
    public void load() {
        multiPowerGenerator = new MultiBlockCenter("multi-block-solid-fuel-generator"){{
            health = 100;
            requirements(Category.power,ItemStack.with(Items.lead, 100));
            construction = solidFuelGenerator;
            outputsPower = true;
            consItems = ItemStack.with(Items.pyratite, 1);
            consumes.items(ItemStack.with(Items.pyratite, 1));
        }};
    }
}