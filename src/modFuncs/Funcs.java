package modFuncs;

import arc.math.geom.Vec2;
import arc.util.Log;

import java.util.ArrayList;

public class Funcs {
    public static String[][] rotateMatrix(String[][] root, int steps){
        String[][] finished = new String[root.length][root[0].length];
        Vec2 center = new Vec2(root.length - 1, root[0].length - 1).scl(0.5f);
        Vec2 tmp = new Vec2(0, 0);
        for(int i = 0;i < root.length;i++){
            for(int z = 0;z < root[0].length;z++){
                tmp = tmp.set(i, z).rotateAround(center, steps * 90);
                finished[(int)tmp.x][(int)tmp.y] = root[i][z];
            }
        }
        return finished;
    }

    public static ArrayList<ArrayList<String>> rotateMatrix(ArrayList<ArrayList<String>> root, int steps){
        ArrayList<ArrayList<String>> finished = new ArrayList<ArrayList<String>>();
        Vec2 center = new Vec2(root.size() - 1, root.get(0).size() - 1).scl(0.5f);
        Vec2 tmp = new Vec2(0, 0);
        for(int i = 0;i < root.size();i++) finished.add(new ArrayList<String>());
        for(int i = 0;i < root.size();i++){
            for(int z = 0;z < root.get(i).size();z++){
                tmp = tmp.set(i, z).rotateAround(center, steps * 90);
                finished.get((int)tmp.x).add((int)tmp.y,root.get(i).get(z));
            }
        }
        return finished;
    }
}
