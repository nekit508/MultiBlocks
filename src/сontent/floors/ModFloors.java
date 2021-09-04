package сontent.floors;

import arc.util.Log;
import mindustry.content.StatusEffects;
import mindustry.ctype.ContentList;
import mindustry.graphics.CacheLayer;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import сontent.liquids.ModLiquids;

public class ModFloors implements ContentList {
    public static Block tritiumFloor, deuteriumFloor, hydrogenFloor, oxygenFloor;

    @Override
    public void load() {
        Log.info("Loading floors");
        tritiumFloor = new Floor("gas-tritium-floor"){{
            speedMultiplier = 0.2f;
            variants = 0;
            liquidDrop = ModLiquids.tritium;
            liquidMultiplier = 1.0f;
            isLiquid = true;
            //TODO maybe new status effect
            /*status = StatusEffects.wet;
            statusDuration = 120f;*/
            drownTime = 140f;
            cacheLayer = CacheLayer.water;
            albedo = 0.5f;
        }};
        deuteriumFloor = new Floor("gas-deuterium-floor"){{
            speedMultiplier = 0.2f;
            variants = 0;
            liquidDrop = ModLiquids.deuterium;
            liquidMultiplier = 1.0f;
            isLiquid = true;
            //TODO maybe new status effect
            /*status = StatusEffects.wet;
            statusDuration = 120f;*/
            drownTime = 140f;
            cacheLayer = CacheLayer.water;
            albedo = 0.5f;
        }};
        hydrogenFloor = new Floor("gas-hydrogen-floor"){{
            speedMultiplier = 0.2f;
            variants = 0;
            liquidDrop = ModLiquids.hydrogen;
            liquidMultiplier = 1.0f;
            isLiquid = true;
            //TODO maybe new status effect
            /*status = StatusEffects.wet;
            statusDuration = 120f;*/
            drownTime = 140f;
            cacheLayer = CacheLayer.water;
            albedo = 0.5f;
        }};
        oxygenFloor = new Floor("gas-oxygen-floor"){{
            speedMultiplier = 0.2f;
            variants = 0;
            liquidDrop = ModLiquids.oxygen;
            liquidMultiplier = 1.0f;
            isLiquid = true;
            //TODO maybe new status effect
            /*status = StatusEffects.wet;
            statusDuration = 120f;*/
            drownTime = 140f;
            cacheLayer = CacheLayer.water;
            albedo = 0.5f;
        }};
    }
}