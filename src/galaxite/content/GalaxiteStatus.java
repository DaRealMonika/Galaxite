package galaxite.content;

import mindustry.type.StatusEffect;

public class GalaxiteStatus {
    public static StatusEffect

    //special - Thrygatis

    magmaticBooster, targeted;

    public static void load() {
        magmaticBooster = new StatusEffect("magmatic-booster"){{
            damageMultiplier = 1.2f;
            healthMultiplier = 0.8f;
            speedMultiplier = 1.4f;
            reloadMultiplier = 1.23f;
            buildSpeedMultiplier = 0.8f;
        }};

        targeted = new StatusEffect("targeted");
    }
}