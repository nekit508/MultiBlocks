package modVars;

public class ConstructionDicts {
    public static String[][] siliconFactory = new String[][] {
            {"i", "mod-java-mod-multi-block-inner"},
            {"b", "mod-java-mod-lead-wall"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"f", "off"},
    };
    public static String[][] graphiteFactory = new String[][] {
            {"i", "mod-java-mod-multi-block-inner"},
            {"b", "mod-java-mod-lead-wall"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"f", "off"},
    };
    public static String[][] metaglassFactory = new String[][]{
            {"i", "mod-java-mod-multi-block-inner"},
            {"b", "mod-java-mod-lead-wall"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"f", "off"},
            {"c", "copper-wall"},
    };
    public static String[][] solidFuelGenerator = new String[][]{
            {"i", "mod-java-mod-multi-block-inner"},
            {"b", "mod-java-mod-lead-wall"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"f", "off"},
            {"c", "copper-wall"},
    };
    public static String[][] liquidFactory = new String[][]{
            {"i", "mod-java-mod-multi-block-liquid-inner"},
            {"b", "mod-java-mod-lead-wall"},
            {"o", "mod-java-mod-multi-block-liquid-outer"},
            {"f", "off"},
    };
    public static String[][] fusionReactor = new String[][]{
            {"i", "mod-java-mod-multi-block-inner"},
            {"w", "thorium-wall"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"f", "off"},
            {"n", "mod-java-mod-electric-interface"},
            {"p", "pulse-conduit"},
            {"t", "titanium-wall"},
    };
    public static String[][] oilFactory = new String[][]{
            {"i", "mod-java-mod-multi-block-inner"},
            {"o", "mod-java-mod-multi-block-outer"},
            {"l", "mod-java-mod-multi-block-liquid-inner"},
            {"q", "mod-java-mod-multi-block-liquid-outer"},
            {"f", "off"},
            {"n", "mod-java-mod-electric-interface"},
            {"p", "pulse-conduit"},
            {"t", "titanium-wall"},
            {"b", "mod-java-mod-battery"},
    };
}
