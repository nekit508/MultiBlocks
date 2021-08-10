package modClasses;
import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.util.Log;
import arc.util.Strings;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;
import mindustry.ui.Bar;
import mindustry.world.Block;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.consumers.Consume;
import mindustry.world.consumers.ConsumeItems;
import сontent.blocks.ModBlocks;

import java.util.Arrays;

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

    public class MultiBuildingCenter extends GenericCrafterBuild {
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
            tickCounter ++;
            if(tickCounter > 60){
                tickCounter = 0;
                structureEnded = checkTiles();
            }
            if(structureEnded){
                lootItems();

                super.update();
            }
        }

        public boolean checkTiles(){
            ending = 0;
            for(int i = 0; i < construction.data.size(); i++){
                for(int z = 0; z < construction.data.get(i).size(); z++){
                    if(!world.tileWorld(x + i*tilesize + construction.offSet*tilesize, y + z*tilesize + construction.offSet*tilesize).block().name.equals(construction.data.get(i).get(z)) && !construction.data.get(i).get(z).equals("off")){
                        return false;
                    }
                }
            }
            return true;
        }

        public void lootItems(){
            for(int i = 0; i < construction.data.size(); i++) {
                for(int z = 0; z < construction.data.get(i).size(); z++) {
                    Building build = world.buildWorld(x + i * tilesize + construction.offSet * tilesize,y + z * tilesize + construction.offSet * tilesize);
                    if(build != null && build != this){
                        Log.info(build.block.name);
                        if(build.block.name.equals("mod-java-mod-multi-block-outer")){
                            if(outputItem != null){
                                int amount = build.block.itemCapacity - build.items.get(outputItem.item);
                                amount = Math.min(items.get(outputItem.item),amount);
                                items.remove(outputItem.item,amount);
                                build.items.add(outputItem.item,amount);
                            }
                        }else if(build.block.name.equals("mod-java-mod-multi-block-liquid-outer")){
                            if(outputLiquid != null){
                                float amount = build.block.liquidCapacity - build.liquids.get(outputLiquid.liquid);
                                amount = Math.min(liquids.get(outputLiquid.liquid),amount);
                                liquids.remove(outputLiquid.liquid,amount);
                                build.liquids.add(outputLiquid.liquid,amount);
                            }
                        }else if(build.block.name.equals("mod-java-mod-multi-block-inner")){
                            for(ItemStack cons:consItems) {
                                Item itm = cons.item;
                                int amount = block.itemCapacity - items.get(itm);
                                amount = Math.min(build.items.get(itm), amount);
                                build.items.remove(itm, amount);
                                items.add(itm, amount);
                            }
                        }else if(build.block.name.equals("mod-java-mod-multi-block-liquid-inner")){
                            for(LiquidStack cons:consLiquid){
                                Liquid lqd = cons.liquid;
                                float amount = block.liquidCapacity - liquids.get(lqd);
                                amount = Math.min(build.liquids.get(lqd),amount);
                                build.liquids.remove(lqd,amount);
                                liquids.add(lqd,amount);
                            }
                        }
                    }
                }
            }
        }
    }
}
