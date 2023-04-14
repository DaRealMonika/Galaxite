package galaxite.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class GalaxiteLiquids {
    public static Liquid

    //liquid - Thrygatis

    magma,

    //gas - Thrygatis

    aethephus;

    public static void load(){
        magma = new Liquid("magma", Color.valueOf("f15454")){{
            effect = StatusEffects.melting;
            viscosity = 0.8f;
            heatCapacity = 0.2f;
            temperature = 1f;
            flammability = 1f;
            capPuddles = false;
            coolant = false;
        }};

        aethephus = new Liquid("aethephus", Color.valueOf("ffcfad")){{
            gas = true;
            effect = StatusEffects.burning;
            temperature = 0.67f;
        }};
    }
}