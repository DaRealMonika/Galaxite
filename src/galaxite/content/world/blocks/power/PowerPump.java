package galaxite.content.world.blocks.power;

import arc.Core;
import arc.struct.EnumSet;
import arc.util.Strings;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.Tile;
import mindustry.world.blocks.production.Pump;
import mindustry.world.meta.*;

public class PowerPump extends Pump {
    public Float powerProduction;
    public PowerPump(String name){
        super(name);
        sync = true;
        hasPower = true;
        outputsPower = true;
        flags = EnumSet.of(BlockFlag.generator);
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rot){
        return (tile.floor().liquidDrop != null && tile.floor().liquidDrop.temperature > 0.5f);
    }

    @Override
    public void setStats() {
        super.setStats();
        stats.remove(Stat.output);
        stats.add(Stat.basePowerGeneration, powerProduction * 60, StatUnit.powerSecond);
    }

    @Override
    public void setBars() {
        super.setBars();
        if (hasPower && outputsPower) {
           addBar("power", (PowerPumpBuild entity) -> new Bar(() ->
                   Core.bundle.format("bar.powerOutput",
                   Strings.fixed(entity.getPowerProduction() * 60 * entity.timeScale(), 1)),
                   () -> Pal.powerBar,
                   () -> entity.productionEfficiency));
        }
    }

    public class PowerPumpBuild extends PumpBuild {
        public Float generateTime;
        public Float productionEfficiency = 0.0f;

        @Override
        public float warmup() {
            return productionEfficiency;
        }
    }
}