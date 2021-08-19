package modClasses;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.util.Log;
import modVars.Effects;
//import mindustry.annotations.Annotations.*;

public class FusionReactor extends MultiBlockCenter{
    public int[] inPoint;
    private TextureRegion warmUpRegion;
    public FusionReactor(String name) {
        super(name);
    }

    @Override
    public void load() {
        super.load();
        warmUpRegion = Core.atlas.find(name + "-warmupregion");
    }

    @Override
    public void setBars() {
        super.setBars();
        // TODO warmup bar
    }

    public class FusionReactorBuild extends MultiBuildingCenter{
        float warmUp = 0f;
        float curAngle = 0f;
        @Override
        public void onDestroyed() {
            super.onDestroyed();
            if(warmUp > 0.8){
                Effects.FusionReactorExplode(x, y, this, tile);
            }
        }

        @Override
        public void draw() {
            super.draw();
            Draw.alpha(warmUp);
            Draw.rect(warmUpRegion, x, y);
        }

        @Override
        public void update() {
            if(tickCounter > 60){
                tickCounter = 0;
                structureEnded = checkTiles();
            }
            if(structureEnded){
                if(warmUp >= 1f) {
                    lootItems();
                    craft();
                }else{
                    warmUp += 1f / 300f;
                }
            }else{
                warmUp = 0f;
            }
            tickCounter ++;
            curAngle += warmUp;
            if(curAngle >= 360f) curAngle = 0f;
        }
    }
}
