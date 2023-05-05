package galaxite.content.statuseffects;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.type.StatusEffect;

public class VisualStatusEffect extends StatusEffect {
    public static Boolean rotate;
    public static String sprite;
    public static Float rotateSpeed;
    public static Color spriteColor;
    private static TextureRegion region;

    public VisualStatusEffect(String name){
        super(name);
    }

    @Override
    public void load() {
        super.load();
        region = Icon.icons.get(sprite) != null ? Icon.icons.get(sprite).getRegion() : Core.atlas.find(sprite);
    }

    @Override
    public void draw(Unit unit, float time){
        super.draw(unit, time);

        if (spriteColor != null) Draw.color(spriteColor);
        Draw.rect(region, unit.x + Angles.trnsx(unit.rotation, 0, 0), unit.y + Angles.trnsy(unit.rotation, 0, 0), Time.time * rotateSpeed);
    }
}