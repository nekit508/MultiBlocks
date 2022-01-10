package сontent.blocks;
import classes.blocks.MBsTools.MBItemPort;
import classes.blocks.MBsTools.MBLiquidPort;

public class MBTools{
    public MBTools(){
        ModBlocks.itemIn = new MBItemPort("items-in") {{
            mode = true;
        }};
        ModBlocks.itemIn = new MBItemPort("items-out") {{
            mode = false;
        }};
        ModBlocks.liquidIn = new MBLiquidPort("liquids-in") {{
            mode = true;
        }};
        ModBlocks.liquidOut = new MBLiquidPort("liquids-out") {{
            mode = false;
        }};
    }
}
