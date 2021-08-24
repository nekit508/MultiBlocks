package mod;

import mindustry.ctype.ContentList;
import mindustry.mod.*;
import mindustry.type.Category;
import modVars.Constructions;
import modVars.ConstructionDicts;
import сontent.shaders.ModShaders;

public class ExtJavaMod extends Mod{

    public ExtJavaMod(){
    }

    @Override
    public void loadContent(){
        Constructions.init();
        ModShaders.init();
        new modContentLoader(ContentList::load);
    }

}
