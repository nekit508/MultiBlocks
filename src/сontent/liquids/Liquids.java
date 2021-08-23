package сontent.liquids;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Liquid;

public class Liquids implements ContentList {
    public static Liquid deuterium, tritium, hydrogen, oxygen;

    @Override
    public void load() {
        deuterium = new Liquid("gas-deuterium"){{
            color = new Color(200,0,200);
            flammability = 1.05f;
            explosiveness = 0.95f;
            temperature = 0.5f;
        }};
        tritium = new Liquid("gas-tritium"){{
            color = new Color(100,0,200);
            flammability = 1.1f;
            explosiveness = 1f;
            temperature = 0.5f;
        }};
        hydrogen = new Liquid("gas-hydrogen"){{
            color = new Color(200,0,0);
            flammability = 1f;
            explosiveness = 0.9f;
            temperature = 0.5f;
        }};
        oxygen = new Liquid("gas-oxygen"){{
            color = new Color(100,100,200);
            flammability = 0.6f;
            explosiveness = 0.5f;
            temperature = 0.5f;
        }};
    }
}
