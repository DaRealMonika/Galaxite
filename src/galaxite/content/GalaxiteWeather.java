package galaxite.content;

import galaxite.content.world.weather.*;
import mindustry.content.*;
import mindustry.gen.*;
import mindustry.type.*;

public class GalaxiteWeather {
    public static Weather

    //dangerous - Thrygatis
    moltenRain;

    public static void load() {
        moltenRain = new BurningRain("molten-rain"){{
            status = StatusEffects.melting;
            sound = Sounds.rain;
            soundVol = 0.35f;
            liquid = Liquids.slag;
            color = StatusEffects.melting.color;
        }};
    }
}