package сontent.blocks;

import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
// import mindustry.world.blocks.defense.ForceProjector;
import mindustry.world.blocks.defense.Wall;

import static сontent.blocks.ModBlocks.*;

// import modClasses.CircleForceProjector;

public class ModDefense implements ContentList {
    @Override
    public void load() {
        leadWall = new Wall("lead-wall"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 320;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.lead, 8));
        }};
        largeLeadWall = new Wall("lead-wall-large"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1280;
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
	    copperCoil = new Wall("copper-coil"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 500;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.copper, 32));
	    }};
		beanPart1 = new Wall("bean-2"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.sporePod, 1));
        }};
        beanPart2 = new Wall("bean-5"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.sporePod, 1));
        }};
        beanPart3 = new Wall("bean-6"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.sporePod, 1));
        }};
        beanPart4 = new Wall("bean-8"){{
            lightningChance = -1f;
            chanceDeflect = -1f;
            health = 1;
            size = 1;
            requirements(Category.defense, ItemStack.with(Items.sporePod, 1));
        }};
		/*
		this is disbalance
		i dont rnow how fix this disbalance
		either will not be used, or will be like in "copper mod"
        forceWall = new ForceProjector("force-wall"){{
            health = 750;
            shieldHealth = 2500;
            radius = 12f;
            phaseRadiusBoost = 1f;
            phaseShieldBoost = 1;
            size = 2;
            hasItems = false;
            requirements(Category.defense, ItemStack.with(Items.titanium, 40, Items.silicon, 20, Items.graphite, 30));
            consumes.power(3);
            consumes.item(Items.phaseFabric).boost();
        }};
		does not bring anything new to the gameplay and will be just rubbish.
		Just in case, let it be
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
		*/
    }
}
