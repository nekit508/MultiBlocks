package classes.blocks.MBs;

import arc.func.Prov;
import arc.math.Mathf;
import classes.blocks.MBParts.BaseMBPart;
import classes.blocks.MBsTools.MBItemPort;
import classes.blocks.MBsTools.MBLiquidPort;
import classes.consumers.BaseConsume;
import classes.constructions.BaseConstruction;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;
import mindustry.world.Block;

public class BaseMB extends Block {
    public Prov<BaseConstruction> construction;
    public BaseConsume consume;
    public float craftTime = 80, warmupSpeed = 0.019f;
    float speedUp = 1f, warmupUp = 1f, energyInIncrease = 1f, energyOutIncrease = 1f;

    public BaseMB(String name) {
        super(name);
        update = true;
        hasItems = true;
        hasLiquids = true;
        itemCapacity = 30;
        liquidCapacity = 30f;
        noUpdateDisabled = true;
        size = 1;
    }

    public class BaseMBBuilding extends Building{
        boolean isEnded = false;
        float progress = 0f;
        float totalProgress = 0f;
        float warmup = 0f;
        // for memory economizing
        Block block;
        Building building;
        BaseMBPart blockPart;

        @Override
        public void updateTile() {
            super.updateTile();
            isEnded = construction.get().check(this);
            if(isEnded){
                checkConsumes();
                checkBlocksInScheme();
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
                construction.get().drawBluePrint(this);
            }
        }

        void checkConsumes(){
            if(consume.canConsume(this)){
                progress += getProgressIncrease(craftTime / speedUp);
                totalProgress += delta();
                warmup = Mathf.approachDelta(warmup, 1f, warmupSpeed * warmupUp);
                if(progress >= 1f){
                    consume.consume(this);
                    progress %= 1f;
                }
            }else{
                warmup = Mathf.approachDelta(warmup, 0f, warmupSpeed * warmupUp);
            }
        }

        void checkBlocksInScheme(){
            for(int x = 0;x < construction.get().bluePrint.length;x++){
                for(int y = 0;y < construction.get().bluePrint[x].length;y++){
                    building = Vars.world.build(x - construction.get().offset + tileX(), y - construction.get().offset + tileY());
                    if(building != null){
                        block = building.block();
                        if(block instanceof MBItemPort){
                            if(((MBItemPort) block).mode) {
                                for (ItemStack stack : consume.items) {
                                    int remaining = itemCapacity - items.get(stack.item);
                                    if (remaining >= 1 && building.items.get(stack.item) >= 1) {
                                        items.add(stack.item, 1);
                                        building.items.remove(stack.item, 1);
                                    }
                                }
                            }else{
                                for (ItemStack stack : consume.itemsOut) {
                                    int remaining = block.itemCapacity - building.items.get(stack.item);
                                    if (remaining >= 1 && items.get(stack.item) >= 1) {
                                        building.items.add(stack.item, 1);
                                        items.remove(stack.item, 1);
                                    }
                                }
                            }
                        }else if(block instanceof MBLiquidPort){
                            if(((MBLiquidPort) block).mode) {
                                for(LiquidStack stack: consume.liquidsOut){
                                    float remaining = liquidCapacity - liquids.get(stack.liquid);
                                    float canOut = Math.min(building.liquids.get(stack.liquid), remaining);
                                    liquids.add(stack.liquid, canOut);
                                    building.liquids.remove(stack.liquid, canOut);
                                }
                            }else{
                                for(LiquidStack stack: consume.liquidsOut){
                                    float remaining = block.liquidCapacity - building.liquids.get(stack.liquid);
                                    float canOut = Math.min(liquids.get(stack.liquid), remaining);
                                    building.liquids.add(stack.liquid, canOut);
                                    liquids.remove(stack.liquid, canOut);
                                }
                            }
                        }else if(block instanceof BaseMBPart){
                            blockPart = (BaseMBPart) block;
                            speedUp += blockPart.speedUp;
                            warmupUp += blockPart.warmupUp;
                            energyInIncrease += blockPart.energyInIncrease;
                            energyOutIncrease += blockPart.energyOutIncrease;
                        }
                    }
                }
            }
        }
    }
}
