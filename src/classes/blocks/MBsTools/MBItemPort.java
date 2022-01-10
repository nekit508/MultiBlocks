package classes.blocks.MBsTools;

import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.world.blocks.storage.StorageBlock;

public class MBItemPort extends StorageBlock {
    public boolean mode = true;
    public MBItemPort(String name) {
        super(name);
    }

    public class MBItemPortBuilding extends StorageBuild {
        @Override
        public boolean acceptItem(Building source, Item item) {
            return super.acceptItem(source, item) && mode;
        }
    }
}
