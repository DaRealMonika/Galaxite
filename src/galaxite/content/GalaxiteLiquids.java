package galaxite.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.type.*;

import static galaxite.content.GalaxiteStatus.*;

public class GalaxiteLiquids {
    public static Liquid

    //liquid - Thrygatis

    magma,

    //gas - Thrygatis

    scoriaVapor, ferventilisSpores;

    public static void load(){
        magma = new Liquid("magma", Color.valueOf("f15454")){{
            effect = StatusEffects.melting;
            viscosity = 0.8f;
            heatCapacity = 0.2f;
            temperature = 1.8f;
            flammability = 1f;
            capPuddles = false;
            coolant = false;
        }};

        scoriaVapor = new Liquid("scoria-vapor", Color.valueOf("ffcfad")){{
            gas = true;
            effect = StatusEffects.burning;
            temperature = 0.67f;
            coolant = false;
        }};

        ferventilisSpores = new Liquid("ferventilis-spores", Color.valueOf("9be04b")){{
            gas = true;
            effect = infested;
            coolant = false;
        }};
    }
}