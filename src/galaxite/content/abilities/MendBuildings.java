package galaxite.content.abilities;

import arc.Core;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.entities.Units;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;

public class MendBuildings extends Ability {
    public int amount;
    public float reload;
    public float range;
    public float b;
    public boolean healed;

    public MendBuildings(Integer am, Float rel, Float ran){
        amount = am;
        reload = rel;
        range = ran;
    }

    @Override
    public void update(Unit unit){
        b += Time.delta;

        if (b >= reload) {
            healed = false;

            Units.nearbyBuildings(unit.x, unit.y, range, building -> {
                if (building.team == unit.team && building.health < building.maxHealth) {
                    Fx.heal.at(building);
                    healed = true;
                    building.heal(amount);
                }
            });
            if (healed) {
                Fx.healWaveDynamic.at(unit, range);
            }
        }
    }

    @Override
    public String localized(){
        return Core.bundle.format("ability.galaxite-mendBuilding", amount, reload/60, range/8);
    }
}