package modVars;

import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import mindustry.content.Liquids;
import mindustry.entities.Damage;
import mindustry.entities.Effect;
import mindustry.entities.Puddles;
import mindustry.entities.bullet.LiquidBulletType;
import mindustry.game.Team;
import mindustry.gen.*;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.type.Liquid;
import mindustry.world.Tile;
import сontent.shaders.ModShaders;
import сontent.weathers.ModWeather;

import java.util.Random;

import static mindustry.Vars.tilesize;
import static mindustry.Vars.world;

public class Effects {
    static Random rand = new Random();

    public static void hotEffect(Building b){
        Draw.draw(Layer.blockOver + 1f, ()->{
            Draw.shader(ModShaders.hot);
            Draw.rect(b.block.region, b.x, b.y);
            Draw.shader();
        });
    }

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
    public static void FusionReactorExplode(float x, float y, Entityc o, Tile tile){
        for(float i = 0; i < 360; i += 0.5f){
            FusionReactorExplode.speed = (float) Math.random()*6;
            FusionReactorExplode.lifetime = 100f + (float) rand.nextInt(20) - 10f;
            FusionReactorExplode.create(o, Team.derelict, x, y, i);
        }
        Sounds.explosionbig.at(tile);
        Damage.damage(x, y, 15 * tilesize, 2000);
        Effect.shake(3f, 60f, x, y);
        ModWeather.slagRain.create(1f, 3600f);
    }
    public static void FusionEffect(float x, float y){
        new Effect(10, (e)->{
            Draw.color(255, 255, 200);
            Lines.stroke(0);
            Draw.blend(Blending.additive);
            Fill.circle(e.x, e.y, (e.lifetime - e.time) / 4);
            Draw.blend();
            Drawf.light(e.x, e.y, (e.lifetime - e.time)*4, new Color(255,255,224), 0.8f);
        }).at(x, y);
    }
}