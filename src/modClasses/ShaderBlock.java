package modClasses;

import arc.graphics.g2d.Draw;
import mindustry.graphics.Layer;
import mindustry.world.blocks.defense.Wall;
import сontent.shaders.ModShaders;

import static mindustry.Vars.renderer;

public class ShaderBlock extends Wall {
    public ShaderBlock(String name) {
        super(name);
    }

    public class ShaderBuilding extends WallBuild {
        @Override
        public void draw(){
            Draw.draw(Layer.blockOver, ()->{
                Draw.shader(ModShaders.hren);
                Draw.rect(region, x, y);
                Draw.shader();
            });
        }
    }
}
