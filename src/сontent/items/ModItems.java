package сontent.items;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class ModItems implements ContentList {
    public static Item steel;

    @Override
    public void load() {
        steel = new Item("steel"){{
            color = new Color(10, 10, 10, 255);
            hardness = 2;
            radioactivity = 0f;
            lowPriority = false;
        }};
    }
}
