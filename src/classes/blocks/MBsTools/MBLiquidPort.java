package classes.blocks.MBsTools;

import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import mindustry.gen.Building;
import mindustry.type.Liquid;
import mindustry.world.blocks.liquid.LiquidBlock;
import mindustry.world.blocks.liquid.LiquidRouter;

public class MBLiquidPort extends LiquidRouter {
    public boolean mode = true;
    public MBLiquidPort(String name) {
        super(name);
    }

    public TextureRegion[] icons() {
        return new TextureRegion[]{this.region};
    }

    public class MBLiquidPortBuilding extends LiquidRouterBuild{
        @Override
        public void draw() {
            Draw.rect(MBLiquidPort.this.region, x, y);
        }

        @Override
        public void updateTile(){
            if(liquids.total() > 0.01f && !mode){
                dumpLiquid(liquids.current());
            }
        }

        @Override
        public boolean acceptLiquid(Building source, Liquid liquid){
            return super.acceptLiquid(source, liquid) && mode;
        }
    }
}
