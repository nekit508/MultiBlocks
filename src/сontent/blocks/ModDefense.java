package сontent.blocks;

import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.ForceProjector;
import mindustry.world.blocks.defense.Wall;

import static сontent.blocks.ModBlocks.*;

import modClasses.CircleForceProjector;

public class ModDefense implements ContentList {
    @Override
    public void load() {
        leadWall = new Wall("lead-wall"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 400;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.lead, 8));
        }};
        largeLeadWall = new Wall("lead-wall-large"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1600;
            size = 2;
            requirements(Category.defense, ItemStack.with(Items.lead, 32));
        }};
        metaglassWall = new Wall("metaglass-wall"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 20;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.metaglass, 8));
        }};
        largeMetaglassWall = new Wall("metaglass-wall-large"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 80;
            size = 2;
            requirements(Category.defense, ItemStack.with(Items.metaglass, 32));
        }};
        siliconWall = new Wall("silicon-wall"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 40;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.silicon, 8));
        }};
        largeSiliconWall = new Wall("silicon-wall-large"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 160;
            size = 2;
            requirements(Category.defense, ItemStack.with(Items.silicon, 32));
        }};
        forceWall = new ForceProjector("force-wall"){{
            health = 750;
            shieldHealth = 2500;
            radius = 12f;
            phaseRadiusBoost = 1f;
            phaseShieldBoost = 1;
            size = 2;
            hasItems = false;
            requirements(Category.defense, ItemStack.with(Items.titanium, 40, Items.silicon, 20, Items.graphite, 30));
            consumes.power(1);
            consumes.item(Items.phaseFabric).boost();
        }};
        magneticShield = new CircleForceProjector("magnetic-shield"){{
            health = 750;
            shieldHealth = 2500;
            radius = 120f;
            phaseRadiusBoost = 1f;
            phaseShieldBoost = 1;
            size = 2;
            hasItems = false;
            requirements(Category.defense, ItemStack.with(Items.titanium, 40, Items.silicon, 20, Items.graphite, 30));
            consumes.power(1);
            consumes.item(Items.phaseFabric).boost();
        }};
		battery = new Wall("battery"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 150;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.copper, 50, Items.lead, 100));
        }};
		electroInterface = new Wall("electrointerface"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 150;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.copper, 50, Items.titanium, 50));
        }};
    }
}