package galaxite.content.world.weather;

import arc.math.Mathf;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.entities.Fires;
import mindustry.gen.WeatherState;
import mindustry.type.weather.RainWeather;
import mindustry.world.Tile;

public class BurningRain extends RainWeather {
    public static float amount = 0.95f;

    public BurningRain(String name) {
        super(name);
    }

    @Override
    public void update(WeatherState state) {
        if (this.isActive()) {
            if (Mathf.chance(state.intensity * amount) && !Vars.state.isPaused()) {
                var x = Mathf.random(0, Vars.state.map.width * Vars.tilesize - 1);
                var y = Mathf.random(0, Vars.state.map.height * Vars.tilesize - 1);
                Tile tile = Vars.world.tileWorld(x, y);
                if (tile.block() != Blocks.air) Fires.create(tile);
            }
        }
    }
}