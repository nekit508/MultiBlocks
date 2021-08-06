package modClasses;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import mindustry.gen.Building;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.logic.Ranged;
import mindustry.world.blocks.defense.ForceProjector;

import static mindustry.Vars.*;

public class CircleForceProjector extends ForceProjector {
    public CircleForceProjector(String name) {
        super(name);
    }
    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){
        Draw.color(Pal.gray);
        Lines.stroke(3f);
        Lines.circle(x * tilesize + offset, y * tilesize + offset,  radius);
        Draw.color(player.team().color);
        Lines.stroke(1f);
        Lines.circle(x * tilesize + offset, y * tilesize + offset, radius);
        Draw.color();
    }

    public class CircleForceBuild extends ForceProjector.ForceBuild implements Ranged {
        @Override
        public void drawShield(){
            if(!broken){
                float radius = realRadius();

                Draw.z(Layer.shields);

                Draw.color(team.color, Color.white, Mathf.clamp(hit));

                if(Core.settings.getBool("animatedshields")){
                    Fill.circle(x, y,  radius);
                }else{
                    Lines.stroke(1.5f);
                    Draw.alpha(0.09f + Mathf.clamp(0.08f * hit));
                    Fill.circle(x, y, radius);
                    Draw.alpha(1f);
                    Lines.circle(x, y, radius);
                    Draw.reset();
                }
            }

            Draw.reset();
        }
    }
}
