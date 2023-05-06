package galaxite.content;

import arc.graphics.*;
import galaxite.content.statuseffects.*;
import mindustry.type.*;

import static galaxite.content.GalaxiteLiquids.*;

public class GalaxiteStatus {
    public static StatusEffect

    //special - Thrygatis

    magmaticBooster, targeted, infested;

    public static void load() {
        magmaticBooster = new StatusEffect("magmatic-booster"){{
            damageMultiplier = 1.2f;
            healthMultiplier = 0.8f;
            speedMultiplier = 1.4f;
            reloadMultiplier = 1.23f;
            buildSpeedMultiplier = 0.8f;
        }};

        targeted = new VisualStatusEffect("targeted"){{
            rotate = true;
            sprite = "commandRally";
            rotateSpeed = 8f;
            spriteColor = Color.valueOf("dc2949");
            color = Color.valueOf("dc2949");
        }};

        infested = new VirusStatusEffect("infested"){{
            damage = 0.01f;
            speedMultiplier = 0.8f;
            damageMultiplier = 1.2f;
            reloadMultiplier = 0.7f;
            permanent = true;
        }};
    }
}