package mod;

import mindustry.ctype.ContentList;
import mindustry.mod.*;

public class ExtJavaMod extends Mod{
    public ExtJavaMod(){

    }


    @Override
    public void loadContent(){
        new ModContentLoader(ContentList::load);
    }

}
