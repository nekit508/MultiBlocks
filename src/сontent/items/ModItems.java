package сontent.items;

import arc.util.Log;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class ModItems implements ContentList {
    public static Item deuterium,tritium,oxygen,hydrogen,FsSolka;

    @Override
    public void load() {
        Log.info("Loading items");
        deuterium = new Item("gas-deuterium"){{
            cost = 1f;
            hardness = 3;
            alwaysUnlocked = false;
        }};
        tritium = new Item("gas-tritium"){{
            cost = 1f;
            hardness = 3;
            alwaysUnlocked = false;
        }};
        hydrogen = new Item("gas-hydrogen"){{
            cost = 1f;
            hardness = 3;
            alwaysUnlocked = false;
        }};
        oxygen = new Item("gas-oxygen"){{
            cost = 1f;
            hardness = 3;
            alwaysUnlocked = false;
        }};
    }
}
