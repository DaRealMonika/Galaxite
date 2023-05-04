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

    public VisualStatusEffect(String name){
        super(name);
    }

    @Override
    public void update(Unit unit, float time){
        super.update(unit, time);
        var Sprite = new TextureRegion();
        if (Icon.icons.get(sprite) != null) Sprite = Icon.icons.get(sprite).getRegion();
        else Sprite = Core.atlas.find(sprite);

        if (spriteColor != null) Draw.color(spriteColor);
        Draw.rect(Sprite, unit.x + Angles.trnsx(unit.rotation, 0, 0), unit.y + Angles.trnsy(unit.rotation, 0, 0), Time.time * rotateSpeed);
    }
}