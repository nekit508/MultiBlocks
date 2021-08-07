package modVars;

import arc.util.Log;

import java.util.ArrayList;

public class ConstructionDicts {
    public static ArrayList<ArrayList<String>> standartCode = new ArrayList();

    public static void init(){
        ArrayList<String> l1 = new ArrayList<>();l1.add("i");l1.add("mod-java-mod-multi-block-inner");
        ArrayList<String> l2 = new ArrayList<>();l2.add("o");l2.add("mod-java-mod-multi-block-outer");
        ArrayList<String> l3 = new ArrayList<>();l3.add("f");l3.add("off");
        ArrayList<String> l4 = new ArrayList<>();l4.add("b");l4.add("mod-java-mod-lead-wall");
        ArrayList<String> l5 = new ArrayList<>();l5.add("c");l5.add("copper-wall");
        standartCode.add(l1);
        standartCode.add(l2);
        standartCode.add(l3);
        standartCode.add(l4);
        standartCode.add(l5);
    }
}
