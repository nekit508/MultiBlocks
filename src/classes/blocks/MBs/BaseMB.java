package classes.blocks.MBs;

import arc.math.Mathf;
import arc.util.Log;
import classes.blocks.MBsTools.MBItemPort;
import classes.blocks.MBsTools.MBLiquidPort;
import classes.consumers.BaseConsume;
import classes.constructions.BaseConstruction;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.gen.Teamc;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;
import mindustry.world.Block;

public class BaseMB extends Block {
    public BaseConstruction construction;
    public BaseConsume consume;
    float craftTime = 80;
    float warmupSpeed = 0.019f;

    public BaseMB(String name) {
        super(name);
        update = true;
        hasItems = true;
        hasLiquids = true;
        itemCapacity = 30;
        liquidCapacity = 30f;
        noUpdateDisabled = true;
    }

    public class BaseMBBuilding extends Building{
        boolean isEnded = false;
        float progress = 0f;
        float totalProgress = 0f;
        float warmup = 0f;

        @Override
        public void updateTile() {
            super.updateTile();
            isEnded = construction.check(this);
            Log.info(isEnded);
            if(isEnded){
                checkConsumes();
                Log.info(1);
            }
        }

        @Override
        public boolean acceptItem(Building source, Item item) {
            return items.get(item) < itemCapacity;
        }

        @Override
        public boolean acceptLiquid(Building source, Liquid liquid) {
            return liquids.get(liquid) < liquidCapacity;
        }

        @Override
        public void handleItem(Building source, Item item) {
            items.add(item, 1);
        }

        @Override
        public void handleLiquid(Building source, Liquid liquid, float amount) {
            liquids.add(liquid, amount);
        }

        @Override
        public void draw() {
            super.draw();
            if(!isEnded){
                construction.drawBluePrint(this);
            }
        }

        void checkConsumes(){
            if(consume.canConsume(this)){
                progress += getProgressIncrease(craftTime);
                totalProgress += delta();
                warmup = Mathf.approachDelta(warmup, 1f, warmupSpeed);
                if(progress >= 1f){
                    consume.consume(this);
                    progress %= 1f;
                }
            }else{
                warmup = Mathf.approachDelta(warmup, 0f, warmupSpeed);
            }
        }

        void dumpL(Building building, Liquid liquid, float amount){
            building.liquids.add(liquid, amount);
        }

        void checkBlocksInScheme(){
            Block block;
            for(int x = 0;x < construction.bluePrint.length;x++){
                for(int y = 0;y < construction.bluePrint[x].length;y++){
                    Building building = Vars.world.build(x - construction.offset + tileX(), y - construction.offset + tileY());
                    if(building != null){
                        block = building.block();
                        if(block instanceof MBItemPort){
                            //noinspection StatementWithEmptyBody
                            if(((MBItemPort) block).mode);
                            if(!((MBItemPort) block).mode){
                                if(timer(timerDump, dumpTime / timeScale)){
                                    for(ItemStack stack: consume.itemsOut){
                                        int remaining = block.itemCapacity - building.items.get(stack.item);
                                        if(remaining >= 1 && items.get(stack.item) >= 1){
                                            building.items.add(stack.item, 1);
                                            items.remove(stack.item, 1);
                                        }
                                    }
                                }
                            }
                        }
                        block = building.block();
                        if(block instanceof MBLiquidPort){
                            //noinspection StatementWithEmptyBody
                            if(((MBLiquidPort) block).mode) ;
                            if(!((MBLiquidPort) block).mode) {
                                for(LiquidStack stack: consume.liquidsOut){
                                    float remaining = block.liquidCapacity - liquids.get(stack.liquid);
                                    float canOut = Math.min(liquids.get(stack.liquid), remaining);
                                    building.liquids.add(stack.liquid, canOut);
                                    liquids.remove(stack.liquid, canOut);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
