package galaxite.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.Items;
import mindustry.type.Item;

public class GalaxiteItems {
    public static Item

    //Thrygatis

    cinderAsh, magmaticCrystal, obsidian, metallicDust;

    public static Seq<Item> thrygatisItems = new Seq<>(), thrygatisOnlyItems = new Seq<>();

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

        thrygatisItems.addAll(Items.scrap, Items.graphite, cinderAsh, magmaticCrystal, obsidian, metallicDust);
        thrygatisOnlyItems.addAll(cinderAsh, magmaticCrystal, obsidian, metallicDust);
    }
}