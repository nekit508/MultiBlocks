package modVars;

import arc.util.Log;

import java.util.ArrayList;

public class ConstructionDicts {
    public static ArrayList<ArrayList<String>> standartCode = new ArrayList<ArrayList<String>>();

    public static void init(){
        ArrayList<String> l1 = new ArrayList<>();l1.add("i");l1.add("mod-java-mod-multi-block-inner");
        ArrayList<String> l2 = new ArrayList<>();l2.add("o");l2.add("mod-java-mod-multi-block-outer");
        ArrayList<String> l3 = new ArrayList<>();l3.add("f");l3.add("off");
        ArrayList<String> l4 = new ArrayList<>();l4.add("b");l4.add("mod-java-mod-lead-wall");
        ArrayList<String> l5 = new ArrayList<>();l5.add("c");l5.add("copper-wall");
        ArrayList<String> l6 = new ArrayList<>();l6.add("l");l6.add("mod-java-mod-multi-block-liquid-inner");
        ArrayList<String> l7 = new ArrayList<>();l7.add("h");l7.add("mod-java-mod-multi-block-liquid-outer");
        ArrayList<String> l8 = new ArrayList<>();l8.add("t");l8.add("titanium-wall");
        ArrayList<String> 19 = new ArrayList<>();19.add("p");19.add("pulse-conduit");
        ArrayList<String> 20 = new ArrayList<>();20.add("w");20.add("thorium-wall");
        ArrayList<String> 21 = new ArrayList<>();21.add("n");21.add("power-node");
        standartCode.add(l1);
        standartCode.add(l2);
        standartCode.add(l3);
        standartCode.add(l4);
        standartCode.add(l5);
        standartCode.add(l6);
        standartCode.add(l7);
        standartCode.add(l8);
        standartCode.add(19);
        standartCode.add(20);
        standartCode.add(21);
    }
}
