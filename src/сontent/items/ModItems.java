package сontent.items;

import arc.util.Log;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class ModItems implements ContentList {
    public static Item deuterium,Item tritium;

    @Override
    public void load() {
        Log.info("Loading items");
        deuterium = new Item("item-deuterium"){{
            cost = 1f;
            hardness = 3;
            alwaysUnlocked = false;
        }};
        tritium = new Item("item-tritium"){{
            cost = 1f;
            hardness = 3;
            alwaysUnlocked = false;
        }};
    }
}
