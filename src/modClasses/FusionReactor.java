package modClasses;

import arc.graphics.Color;
import mindustry.content.Liquids;
import mindustry.entities.bullet.*;
import mindustry.game.Team;
import mindustry.gen.Teamc;

import java.util.Random;

public class FusionReactor extends MultiBlockCenter{
    Random rand = new Random();
    LiquidBulletType bullet = new LiquidBulletType(Liquids.slag){{
        damage = 500f;
        speed = 8f;
        drag = 0.01f;
        lifetime = 100;
        collidesAir = false;
        collidesTeam = true;
    }};
    public FusionReactor(String name) {
        super(name);
    }

    public class FusionReactorBuild extends MultiBuildingCenter{
        @Override
        public void onDestroyed() {
            super.onDestroyed();
            for(float i = 0; i < 360; i += 0.8f){
                bullet.speed = (float) Math.random()*6;
                bullet.lifetime = 100f + (float) rand.nextInt(20) - 10f;
                bullet.create(this, Team.derelict, x, y, i);
            }
        }
    }
}
