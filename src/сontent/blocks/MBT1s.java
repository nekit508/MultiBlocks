package сontent.blocks;
import classes.blocks.MBs.BaseMB;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import сontent.constructions.Constructions;
import сontent.consumes.Consumes;

public class MBT1s{
    public MBT1s(){
        ModBlocks.MBT1Steel = new BaseMB("MBT1Steel"){{
            consume = Consumes.Steel;
            construction = () -> Constructions.MBT1Steel;
            requirements(Category.crafting, ItemStack.with(Items.graphite, 20, Items.copper, 25, Items.lead, 20));
        }};
    }
}
