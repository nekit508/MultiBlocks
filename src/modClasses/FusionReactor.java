package modClasses;

import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.util.Log;
import modVars.Effects;
import mindustry.annotations.Annotations.*;

public class FusionReactor extends MultiBlockCenter{
    public int[] inPoint;
    private @Load("@-warmupregion") TextureRegion warmUpRegion;
    public FusionReactor(String name) {
        super(name);
    }

    @Override
    public void setBars() {
        super.setBars();
        // TODO warmup bar
    }

    public class FusionReactorBuild extends MultiBuildingCenter{
        float warmUp = 0f;
        @Override
        public void onDestroyed() {
            super.onDestroyed();
            if(warmUp > 0.8){
                Effects.FusionReactorExplode(x, y, this);
            }
        }

        @Override
        public void draw() {
            super.draw();
            Draw.alpha(warmUp);
            Log.info(warmUpRegion);
            Draw.rect(warmUpRegion, x, y);
        }

        @Override
        public void update() {
            if(structureEnded && warmUp < 1f) {
                warmUp += 1f / (60f * 5f);
            }else{
                warmUp = 0;
            }
            if(warmUp > 0.95f) {
                super.update();
            }
        }
    }
}
