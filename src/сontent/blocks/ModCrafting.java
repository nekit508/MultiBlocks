package сontent.blocks;

import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.blocks.defense.Wall;
import modClasses.*;
import modVars.Constructions;

import static сontent.blocks.ModBlocks.*;

public class ModCrafting implements ContentList {
    @Override
    public void load() {
        multiSilicon = new MultiBlockCenter("multi-block-silicon"){{
            construction = Constructions.siliconFactory;
            size = 1;
            health = 100;
            hasLiquids = true;
            hasItems = true;
            requirements(Category.crafting, ItemStack.with(Items.lead, 32));
            consItems = ItemStack.with(Items.coal, 1, Items.sand, 2);
            consumes.power(2);
            consumes.items(ItemStack.with(Items.coal, 1, Items.sand, 2));
            outputItem = new ItemStack(Items.silicon, 2);
        }};
        multiGraphite = new MultiBlockCenter("multi-block-graphite"){{
            construction = Constructions.graphiteFactory;
            size = 1;
            health = 100;
            requirements(Category.crafting, ItemStack.with(Items.lead, 32));
            consumes.power(2);
            consumes.items(ItemStack.with(Items.coal, 2));
            consItems = ItemStack.with(Items.coal, 2);
            outputItem = new ItemStack(Items.graphite, 1);
        }};
        multiMetaglass = new MultiBlockCenter("multi-block-metaglass"){{
            construction = Constructions.metaglassFactory;
            size = 1;
            health = 100;
            requirements(Category.crafting, ItemStack.with(Items.lead, 32));
            consumes.power(2);
            consItems = ItemStack.with(Items.lead, 1, Items.sand, 1);
            consumes.items(ItemStack.with(Items.sand, 1, Items.lead, 1));
            outputItem = new ItemStack(Items.metaglass, 1);
        }};
        multiLiquid = new MultiBlockCenter("multi-block-liquid"){{
            construction = Constructions.liquidFactory;
            size = 1;
            health = 100;
            hasLiquids = true;
            hasItems = false;
            requirements(Category.crafting, ItemStack.with(Items.lead, 32));
            consLiquid = new LiquidStack[]{new LiquidStack(Liquids.oil, 1)};
            consumes.power(2);
            consumes.liquid(Liquids.oil, 1);
            outputLiquid = new LiquidStack(Liquids.cryofluid, 1);
        }};
        multiReactor = new FusionReactor("multi-block-reactor"){{
            construction = Constructions.fusionReactor;
            size = 1;
            health = 100;
            requirements(Category.crafting, ItemStack.with(Items.lead, 32));
            consumes.power(20);
            consumes.items(ItemStack.with(Items.coal, 2));
            consItems = ItemStack.with(Items.coal, 2);
            outputItem = new ItemStack(Items.graphite, 1);
            inPoint = new int[]{0,0};
        }};
        oilFactory = new MultiBlockCenter("multi-block-oil-factory"){{
            construction = Constructions.oilFactory;
            liquidCapacity = 500f;
            itemCapacity = 10;
            size = 1;
            health = 100;
            hasLiquids = true;
            hasItems = true;
            requirements(Category.crafting, ItemStack.with(Items.lead, 32));
            consLiquid = new LiquidStack[]{new LiquidStack(Liquids.oil, 1)};
            consItems = new ItemStack[]{new ItemStack(Items.titanium, 1)};
            consumes.power(8);
            consumes.liquid(Liquids.oil, 1f);
            consumes.items(ItemStack.with(Items.titanium, 8));
            outputItem = new ItemStack(Items.plastanium, 5);
            craftTime = 60f;
        }};
    }
}