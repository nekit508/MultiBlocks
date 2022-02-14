package сontent.blocks;

import classes.blocks.MBParts.BaseMBPart;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;

public class MBParts {
    public MBParts(){
        ModBlocks.steelCoil = new BaseMBPart("steel-coil"){{
            requirements(Category.effect, ItemStack.with(Items.lead, 10));
        }};
        ModBlocks.steelPanel = new BaseMBPart("steel-panel"){{
            requirements(Category.effect, ItemStack.with(Items.lead, 10));
            hasShadow = false;
        }};
        ModBlocks.copperCoil = new BaseMBPart("copper-coil"){{
            requirements(Category.effect, ItemStack.with(Items.copper, 10));
        }};
        ModBlocks.copperPanel = new BaseMBPart("copper-panel"){{
            requirements(Category.effect, ItemStack.with(Items.copper, 10));
            hasShadow = false;
        }};
    }
}
