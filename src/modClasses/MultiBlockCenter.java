package modClasses;

import arc.graphics.g2d.Draw;
import arc.util.Log;
import mindustry.gen.Building;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import static mindustry.Vars.*;

public class MultiBlockCenter extends GenericCrafter {
    public int tickCounter = 0;
    public boolean structureEnded = false;
    public Construction construction;
    public ItemStack[] consItems;
    public LiquidStack[] consLiquid;
    public MultiBlockCenter(String name) {
        super(name);
        solid = true;
        update = true;
        itemCapacity = 10;
        hasItems = true;
    }

    @Override
    public void setStats() {
        super.setStats();
        //TODO add structure to description
    }

    public class MultiBuildingCenter extends GenericCrafterBuild {
        Building build = null;
        float ending = 0;

        @Override
        public void draw() {
            super.draw();
            Draw.alpha(0.3f);
            for(int i = 0; i < construction.data.size(); i++) {
                for(int z = 0; z < construction.data.get(i).size(); z++) {
                    Block bl = content.block(construction.data.get(i).get(z));
                    if(bl != null) {
                        Draw.rect(content.block(construction.data.get(i).get(z)).region, i * tilesize + construction.offSet * tilesize + x, z * tilesize + construction.offSet * tilesize + y);
                    }
                }
            }
        }

        @Override
        public void update() {
            if(tickCounter > 60){
                tickCounter = 0;
                structureEnded = checkTiles();
            }
            if(structureEnded){
                lootItems();
                super.update();
            }
            tickCounter ++;
        }

        public boolean checkTiles(){
            ending = 0;
            for(int i = 0; i < construction.data.size(); i++){
                for(int z = 0; z < construction.data.get(i).size(); z++){
                    if(world.tileWorld(x + i*tilesize + construction.offSet*tilesize, y + z*tilesize + construction.offSet*tilesize) != null){
                        if (!world.tileWorld(x + i * tilesize + construction.offSet * tilesize, y + z * tilesize + construction.offSet * tilesize).block().name.equals(construction.data.get(i).get(z)) && !construction.data.get(i).get(z).equals("off")) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public void lootItems(){
            for(int ind = 0;ind < construction.points.length;ind++) {
                int i = construction.points[ind][0];
                int z = construction.points[ind][1];
                build = world.buildWorld(x + i * tilesize + construction.offSet * tilesize, y + z * tilesize + construction.offSet * tilesize);
                if (build != null && build != this) {
                    Log.info(build.block.name);
                    if (build.block.name.equals("mod-java-mod-multi-block-outer")) {
                        if (outputItem != null) {
                            int amount = Math.min(items.get(outputItem.item), build.block.itemCapacity - build.items.get(outputItem.item));
                            items.remove(outputItem.item, amount);
                            build.items.add(outputItem.item, amount);
                        }
                    } else if (build.block.name.equals("mod-java-mod-multi-block-liquid-outer")) {
                        if (outputLiquid != null) {
                            float amount = Math.min(liquids.get(outputLiquid.liquid), build.block.liquidCapacity - build.liquids.get(outputLiquid.liquid));
                            liquids.remove(outputLiquid.liquid, amount);
                            build.liquids.add(outputLiquid.liquid, amount);
                        }
                    } else if (build.block.name.equals("mod-java-mod-multi-block-inner")) {
                        for (ItemStack cons : consItems) {
                            int amount = Math.min(build.items.get(cons.item), block.itemCapacity - items.get(cons.item));
                            build.items.remove(cons.item, amount);
                            items.add(cons.item, amount);
                        }
                    } else if (build.block.name.equals("mod-java-mod-multi-block-liquid-inner")) {
                        for (LiquidStack cons : consLiquid) {
                            float amount = Math.min(build.liquids.get(cons.liquid), block.liquidCapacity - liquids.get(cons.liquid));
                            build.liquids.remove(cons.liquid, amount);
                            liquids.add(cons.liquid, amount);
                        }
                    }
                }
            }
        }
    }
}
