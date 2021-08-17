package modClasses;

import mindustry.content.Liquids;
import mindustry.gen.WeatherState;
import mindustry.type.weather.RainWeather;
import modVars.Effects;

public class SlagRain extends RainWeather {
    public SlagRain(String name) {
        super(name);
        liquid = Liquids.slag;
        color = Liquids.slag.color;
        yspeed = 20f;
        xspeed = 0.5f;
        stroke = 4f;
        sizeMax = 20f;
        sizeMin = 7f;
    }

    @Override
    public void update(WeatherState state) {
        super.update(state);
        for(int i = 0;i < 4;i++) {
            Effects.SlagRainBulb(liquid);
        }
    }
}
