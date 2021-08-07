package modClasses;
import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.util.Log;
import arc.util.Strings;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.ui.Bar;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import сontent.blocks.ModBlocks;

import static mindustry.Vars.*;

public class MultiBlockCenter extends GenericCrafter {
    public int tickCounter = 0;
    public boolean structureEnded = false;
    public Construction construction;
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
                    if(content.block(construction.data.get(i).get(z)) != null) {
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
                    Building build = world.buildWorld(x + i*tilesize + construction.offSet*tilesize, y + z*tilesize + construction.offSet*tilesize);
                    if(build != null) {
                        if (build.block().name.equals("mod-java-mod-multi-block-inner")) {
                            Item itm = build.items.take();
                            if (build.block().hasItems && build.block() != block() && build.items.total() != 0 && items.get(itm) != itemCapacity) {
                                items.add(itm, 1);
                            }else if(itm != null){
                                build.items.add(itm,1);
                            }
                        } else if (build.block().name.equals("mod-java-mod-multi-block-outer")) {
                            if (build.block() != block()) {
                                if (items.has(outputItem.item) && build.items.total() != build.block().itemCapacity){
                                    build.items.add(outputItem.item,1);
                                    items.remove(outputItem.item, 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
