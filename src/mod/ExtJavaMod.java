package mod;

import mindustry.ctype.ContentList;
import mindustry.mod.*;
import mindustry.world.Block;
import modVars.Constructions;
import modVars.ConstructionDicts;

public class ExtJavaMod extends Mod{

    public ExtJavaMod(){
    }

    @Override
    public void loadContent(){
        ConstructionDicts.init();
        Constructions.init();
        new modContentLoader(ContentList::load);
    }

}
