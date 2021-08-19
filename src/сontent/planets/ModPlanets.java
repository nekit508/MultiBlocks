package сontent.planets;

import arc.graphics.Color;
import arc.util.Log;
import mindustry.content.Planets;
import mindustry.ctype.ContentList;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.Planet;

public class ModPlanets implements ContentList {
    public static Planet buxed;

    @Override
    public void load() {
        Log.info("Loading planets");
        buxed = new Planet("planet-buxed", Planets.sun, 3, 1){{
            generator = new BuxedPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            hasAtmosphere = false;
            accessible = true;
            startSector = 0;
            alwaysUnlocked = true;
            landCloudColor = Pal.spore.cpy().a(0.5f);
        }};
    }
}