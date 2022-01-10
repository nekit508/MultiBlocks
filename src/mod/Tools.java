package mod;

import arc.graphics.g2d.Draw;
import mindustry.Vars;
import mindustry.world.Block;

public class Tools {
    public static void drawBlock(Block block, int x, int y) {
        if(block.region != null) {
            Draw.rect(block.region, x * Vars.tilesize, y * Vars.tilesize);
        }
    }
}
