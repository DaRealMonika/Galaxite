package galaxite.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class GalaxiteItems {
    public static Item

    //Thrygatis

    cinderAsh, magmaticCrystal, obsidian, metallicDust;

    public static void load(){
        cinderAsh = new Item("cinder-ash", Color.valueOf("403434")){{
            lowPriority = true;
        }};

        magmaticCrystal = new Item("magmatic-crystal", Color.valueOf("d65023")){{
            flammability = 0.6f;
            cost = 1.5f;
            hardness = 2;
            radioactivity = 0.2f;
        }};

        obsidian = new Item("obsidian", Color.valueOf("000000")){{
            hardness = 2;
            cost = 2f;
        }};

        metallicDust = new Item("metallic-dust", Color.valueOf("555555")){{
            cost = 0.5f;
            buildable = false;
        }};
    }
}