package сontent.shaders;

import arc.files.Fi;
import arc.graphics.gl.Shader;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import arc.util.Time;
import mindustry.Vars;

public class ModShaders {
    public static Hren hren;
    public static Hot hot;

    public static void init(){
        hren = new Hren();
        hot = new Hot();
    }

    public static class Hren extends ModShader{
        public Hren(String fragmentShader, String vertexShader) {
            super(fragmentShader, vertexShader);
        }

        public Hren() {
            super("hren", "default");
        }

        @Override
        public void apply() {
            setUniformf("u_time", Time.time / 60f);
        }
    }

    public static class ModShader extends Shader {
        public ModShader(String fragmentShader, String vertexShader) {
            super(load("shaders/" + vertexShader + ".vert"), load("shaders/" + fragmentShader + ".frag"));
        }
        public static Fi load(String path){
            return Vars.tree.get(path);
        }
    }

    public static class Hot extends ModShader{
        public Hot(String fragmentShader, String vertexShader) {
            super(fragmentShader, vertexShader);
        }

        public Hot() {
            super("hot", "default");
        }

        @Override
        public void apply() {
            setUniformf("rand", new Vec2(Mathf.random(3f),Mathf.random(3f)));
        }
    }
}
