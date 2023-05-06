package galaxite.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.Items;
import mindustry.type.Item;

public class GalaxiteItems {
    public static Item

    //Thrygatis

    cinderAsh, magmaticCrystal, obsidian, metallicDust, ferventilis;

    public static Seq<Item> thrygatisItems = new Seq<>(), thrygatisOnlyItems = new Seq<>();

    public static void load(){
        cinderAsh = new Item("cinder-ash", Color.valueOf("403434")){{
            lowPriority = true;
        }};

        magmaticCrystal = new Item("magmatic-crystal", Color.valueOf("d65023")){{
            flammability = 1.6f;
            cost = 1.5f;
            hardness = 2;
            radioactivity = 0.2f;
            healthScaling = 0.8f;
        }};

        obsidian = new Item("obsidian", Color.valueOf("000000")){{
            healthScaling = 1.4f;
            cost = 2f;
        }};

        metallicDust = new Item("metallic-dust", Color.valueOf("555555")){{
            cost = 0.5f;
            buildable = false;
        }};

        ferventilis = new Item("ferventilis", Color.valueOf("7ed914")){{
            buildable = false;
            cost = 0.3f;
            radioactivity = 1.5f;
            flammability = 1.6f;
        }};

        thrygatisItems.addAll(Items.scrap, Items.graphite, cinderAsh, magmaticCrystal, obsidian, metallicDust, ferventilis);
        thrygatisOnlyItems.addAll(cinderAsh, magmaticCrystal, obsidian, metallicDust, ferventilis);
    }
}