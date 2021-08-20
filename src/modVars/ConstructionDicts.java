package modVars;

public class ConstructionDicts {
    public static String[][] siliconFactoryDict = new String[][] {
            {"i", "mod-java-mod-multi-block-inner"},
            {"b", "mod-java-mod-lead-wall"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"f", "off"},
    };
    public static String[][] graphiteFactoryDict = new String[][] {
            {"i", "mod-java-mod-multi-block-inner"},
            {"b", "mod-java-mod-lead-wall"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"f", "off"},
    };
    public static String[][] metaglassFactoryDict = new String[][]{
            {"i", "mod-java-mod-multi-block-inner"},
            {"b", "mod-java-mod-lead-wall"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"f", "off"},
            {"c", "copper-wall"},
    };
    public static String[][] solidFuelGeneratorDict = new String[][]{
            {"i", "mod-java-mod-multi-block-inner"},
            {"b", "mod-java-mod-lead-wall"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"f", "off"},
            {"c", "copper-wall"},
    };
    public static String[][] liquidFactoryDict = new String[][]{
            {"i", "mod-java-mod-multi-block-liquid-inner"},
            {"b", "mod-java-mod-lead-wall"},
            {"o", "mod-java-mod-multi-block-liquid-outer"},
            {"f", "off"},
    };
    public static String[][] fusionReactorDict = new String[][]{
            {"i", "mod-java-mod-multi-block-inner"},
            {"w", "thorium-wall"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"f", "off"},
            {"n", "mod-java-mod-electric-interface"},
            {"p", "pulse-conduit-0"},
            {"t", "titanium-wall"},
    };
    public static String[][] oilFactoryDict = new String[][]{
            {"i", "mod-java-mod-multi-block-inner"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"l", "mod-java-mod-multi-block-liquid-inner"},
            {"q", "mod-java-mod-multi-block-liquid-outer"},
            {"f", "off"},
            {"n", "mod-java-mod-electric-interface"},
            {"p", "pulse-conduit-0"},
            {"t", "titanium-wall"},
            {"b", "mod-java-mod-battery"},
    };
    public static String[][] electrolyzerDict = new String[][]{
            {"i", "mod-java-mod-multi-block-liquid-inner"},
            {"o", "mod-java-mod-multi-block-liquid-outer"},
            {"f", "off"},
            {"n", "mod-java-mod-electric-interface"},
            {"t", "titanium-wall"},
            {"b", "mod-java-mod-battery"},
            {"m", "mod-java-mod-metaglass-wall"},
    };
}
