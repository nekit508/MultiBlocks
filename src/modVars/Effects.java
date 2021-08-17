package modVars;

import mindustry.content.Liquids;
import mindustry.entities.Puddles;
import mindustry.entities.bullet.LiquidBulletType;
import mindustry.game.Team;
import mindustry.gen.Bullet;
import mindustry.gen.Entityc;
import mindustry.gen.Fire;
import mindustry.gen.Puddle;
import mindustry.type.Liquid;
import mindustry.type.Weather;
import modClasses.SlagRain;
import сontent.weather.ModWeather;

import java.util.Random;

import static mindustry.Vars.tilesize;
import static mindustry.Vars.world;

public class Effects {
    static Random rand = new Random();

    public static LiquidBulletType FusionReactorExplode = new LiquidBulletType(Liquids.slag){
        {
            damage = 500f;
            speed = 8f;
            drag = 0.01f;
            lifetime = 100;
            collidesAir = false;
            collidesTeam = true;
        }

        @Override
        public void despawned(Bullet b) {
            super.despawned(b);
            Puddles.deposit(world.tileWorld(b.x, b.y), liquid, 80f);
        }
    };
    public static void SlagRainBulb(Liquid liquid){
        int y = rand.nextInt(world.height());
        int x = rand.nextInt(world.width());
        Puddles.deposit(world.tileWorld(x * tilesize, y * tilesize), liquid, (float) (rand.nextInt(1800)+200));
        Fire fire = Fire.create();
        fire.x = x * tilesize;
        fire.y = y * tilesize;
        fire.tile = world.tileWorld(x * tilesize, y * tilesize);
        fire.lifetime = 120f;
        fire.baseFlammability = 1f;
        fire.puddleFlammability = 1f;
        fire.add();
    }
    public static void FusionReactorExplode(float x, float y, Entityc o){
        for(float i = 0; i < 360; i += 0.8f){
            FusionReactorExplode.speed = (float) Math.random()*6;
            FusionReactorExplode.lifetime = 100f + (float) rand.nextInt(20) - 10f;
            FusionReactorExplode.create(o, Team.derelict, x, y, i);
            ModWeather.slagRain.create(1f, 360f);
        }
    };
}