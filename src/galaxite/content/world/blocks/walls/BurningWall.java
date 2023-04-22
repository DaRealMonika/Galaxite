package galaxite.content.world.blocks.walls;

import mindustry.Vars;
import mindustry.content.StatusEffects;
import mindustry.entities.Units;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

public class BurningWall extends Wall {
    public Boolean burning;
    public Float damage = 1f;
    public Float range = 1f;

    public BurningWall(String name) {
        super(name);
        update = true;
    }

    @Override
    public void setStats() {
        super.setStats();
        if (burning) {
            stats.add(Stat.abilities, "Apply: @", StatusEffects.burning.localizedName);
        } else {
            stats.add(Stat.damage, damage * 60, StatUnit.seconds);
        }
        stats.add(Stat.range, Vars.tilesize*range);
    }

    public class BurningWallBuild extends WallBuild {
        @Override
        public void updateTile() {
            if (burning) {
                Units.nearbyEnemies(this.team, this.x, this.y, Vars.tilesize*range, unit -> {
                    if (unit.hittable() && unit.targetable(this.team)) {
                        unit.apply(StatusEffects.burning);
                    } else {
                        unit.damage(damage);
                    }
                });
            }
        }
    }
}