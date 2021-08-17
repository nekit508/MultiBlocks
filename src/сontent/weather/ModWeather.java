package сontent.weather;

import mindustry.ctype.ContentList;
import mindustry.type.Weather;
import modClasses.SlagRain;

public class ModWeather implements ContentList {
    public static Weather slagRain;

    @Override
    public void load() {
        for (ContentList contentList : weatherContent) {
            contentList.load();
        }

        slagRain = new SlagRain("weather-slag-rain"){{

        }};
    }

    private ContentList[] weatherContent = {
    };
}