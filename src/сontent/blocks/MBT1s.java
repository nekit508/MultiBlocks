package сontent.blocks;
import classes.blocks.MBs.BaseMB;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import сontent.constructions.Constructions;
import сontent.consumes.Consumes;

public class MBT1s{
    public MBT1s(){
        ModBlocks.MBT1Graphite = new BaseMB("MBT1Graphite"){{
            consume = Consumes.CoalToGraphite;
            construction = Constructions.MBT1Graphite;
            requirements(Category.crafting, new ItemStack[]{new ItemStack(Items.copper, 99999)});
            size = 1;
        }};
    }
}
