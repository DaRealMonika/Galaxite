package galaxite.content;

import arc.graphics.Color;
import galaxite.content.statuseffects.VisualStatusEffect;
import mindustry.gen.Icon;
import mindustry.type.StatusEffect;

import static galaxite.content.GalaxiteLiquids.*;

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
            // TODO make and add sprite for magmatic booster
            uiIcon = magma.uiIcon;
            fullIcon = magma.fullIcon;
        }};

        targeted = new VisualStatusEffect("targeted"){{
            rotate = true;
            sprite = Icon.commandRally.getRegion();
            rotateSpeed = 30f;
            spriteColor = Color.valueOf("dc2949");
            // TODO make and add sprite for targeted
            uiIcon = Icon.commandRally.getRegion();
            fullIcon = Icon.commandRally.getRegion();
        }};
    }
}