package modClasses;

import arc.graphics.g2d.TextureRegion;
import mindustry.world.blocks.liquid.LiquidRouter;

public class MultiBlockLiquidOuter extends LiquidRouter {
    public MultiBlockLiquidOuter(String name) {
        super(name);
        liquidCapacity = 20;
    }
}
