package galaxite.content.abilities;

import arc.Core;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.entities.Units;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;

public class HealUnits extends Ability {
    public int amount;
    public float reload;
    public float range;
    public float b;
    public boolean healed;

    public HealUnits(Integer am, float rel, float ran){
        amount = am;
        reload = rel;
        range = ran;
    }
    @Override
    public void update(Unit Unit){
        b += Time.delta;

        if (b >= reload) {
            healed = false;

            Units.nearby(Unit.team, Unit.x, Unit.y, range, unit -> {
                if (unit.health < unit.maxHealth) {
                    Fx.heal.at(unit);
                    healed = true;
                    unit.heal(amount);
                }
            });
            if (healed) {
                Fx.healWaveDynamic.at(Unit, range);
            }
        }
    }

    @Override
    public String localized(){
        return Core.bundle.format("ability.galaxite-healUnit", amount, reload/60, range/8);
    }
}