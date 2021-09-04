package modClasses;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.util.Log;
import mindustry.Vars;
import mindustry.graphics.Layer;
import modVars.Effects;

public class FusionReactor extends MultiBlockCenter{
    public int[] inPoint;
    TextureRegion topR;
    TextureRegion botR;
    TextureRegion liqR;

    public FusionReactor(String name) {
        super(name);
    }

    @Override
    public void setBars() {
        super.setBars();
        // TODO warmup bar
    }

    @Override
    public void load() {
        super.load();
        botR = Core.atlas.find(name + "-bot");
        topR = Core.atlas.find(name + "-top");
        liqR = Core.atlas.find(name + "-liq");
    }

    public class FusionReactorBuild extends MultiBuildingCenter{
        float warmUp = 0f;
        float curAngle = 0f;
        @Override
        public void onDestroyed() {
            super.onDestroyed();
            if(warmUp > 0.5){
                Effects.FusionReactorExplode(x, y, this, tile);
            }
        }

        @Override
        public void draw() {
            super.draw();
            if(structureEnded) {
                Draw.z(Layer.blockBuilding+5f);
                Draw.rect(botR, x, y - Vars.tilesize);
                Draw.z(Layer.blockBuilding+6f);
                Effects.FusionEffect(x + (float) Math.cos(curAngle) * 88, y + (float) Math.sin(curAngle) * 88);
                Effects.FusionEffect(x + (float) Math.cos(curAngle + 3.14) * 88, y + (float) Math.sin(curAngle + 3.14) * 88);
                Draw.z(Layer.blockBuilding+7f);
                Draw.rect(topR, x, y - Vars.tilesize);
                Draw.reset();
            }
        }

        @Override
        public void update() {
            if(tickCounter > 60){
                tickCounter = 0;
                structureEnded = checkTiles();
            }
            if(structureEnded){
                if(warmUp >= 1f) {
                    Effects.hotEffect(this);
                    lootItems();
                    craft();
                }else{
                    warmUp += 1f / (10f * 60f);
                }
            }else{
                if(warmUp > 0f) {
                    warmUp -= 1f / (2f * 60f);
                }else{
                    warmUp = 0f;
                }
            }
            tickCounter ++;
            curAngle += warmUp/10;
            if(curAngle >= 6.28) curAngle = 0f;
        }
    }
}
