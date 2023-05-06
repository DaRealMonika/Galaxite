package galaxite.content.statuseffects;

import mindustry.type.StatusEffect;

public class VirusStatusEffect extends StatusEffect { // TODO make it a virus
    public static boolean spreadOnContact;
    public static boolean spreadOnHit;
    public static boolean messWithAi;

    public VirusStatusEffect(String name) {
        super(name);
    }
}