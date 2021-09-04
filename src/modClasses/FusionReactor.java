package modClasses;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.util.Log;
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
        topR = Core.atlas.find(name + "-cons");
        topR = Core.atlas.find(name + "-top");
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
                Effects.FusionEffect(x + (float) Math.cos(curAngle) * 88, y + (float) Math.sin(curAngle) * 88);
                Effects.FusionEffect(x + (float) Math.cos(curAngle + 3.14) * 88, y + (float) Math.sin(curAngle + 3.14) * 88);
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
