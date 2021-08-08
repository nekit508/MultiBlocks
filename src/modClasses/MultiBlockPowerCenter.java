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
import mindustry.ui.Bar;
import mindustry.world.blocks.power.BurnerGenerator;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

import static mindustry.Vars.*;

public class MultiBlockPowerCenter extends BurnerGenerator {
    public int tickCounter = 0;
    public boolean structureEnded = false;
    public Construction construction;
    public MultiBlockPowerCenter(String name) {
        super(name);
        update = true;
        itemCapacity = 10;
    }

    @Override
    public void setStats(){
        super.setStats();

        if(hasItems){
            stats.add(Stat.productionTime, itemDuration / 60f, StatUnit.seconds);
        }
    }

    public class MultiBuildingPowerCenter extends BurnerGeneratorBuild {
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
            }else{
                productionEfficiency = 0f;
            }
        }

        public boolean checkTiles(){
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
                        }
                    }
                }
            }
        }
    }
}
