package classes.blocks.MBsTools;

import mindustry.gen.Building;
import mindustry.type.Liquid;
import mindustry.world.blocks.liquid.LiquidRouter;

public class MBLiquidPort extends LiquidRouter {
    public boolean mode = true;
    public MBLiquidPort(String name) {
        super(name);
    }

    public class MBLiquidPortBuilding extends LiquidRouterBuild{
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
