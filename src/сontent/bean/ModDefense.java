package сontent.bean;

import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.Wall;

import static сontent.bean.ModBlocks.*;
public class ModDefense implements ContentList {
    @Override
    public void load() {
        beanPart1 = new Wall("bean-2"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.spore-pod, 1));
        }};
        beanPart2 = new Wall("bean-5"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.spore-pod, 1));
        }};
        beanPart3 = new Wall("bean-6"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.spore-pod, 1));
        }};
        beanPart4 = new Wall("bean-8"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.spore-pod, 1));
        }};
    }
}
