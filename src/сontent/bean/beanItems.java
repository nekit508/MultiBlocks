package сontent.bean;

import arc.util.Log;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class ModItems implements ContentList {
    public static Item FaSolka;

    @Override
    public void load() {
        Log.info("Loading items");
        FaSolka = new Item("FasolkaItIsBean"){{
            cost = 1f;
            hardness = 10;
            alwaysUnlocked = false;
        }};
    }
}
