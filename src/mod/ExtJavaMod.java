package mod;

import mindustry.ctype.ContentList;
import mindustry.mod.*;
import mindustry.type.Category;
import сontent.shaders.ModShaders;

public class ExtJavaMod extends Mod{

    public ExtJavaMod(){
    }

    @Override
    public void loadContent(){
        new modContentLoader(ContentList::load);
    }

}
