package galaxite.content.unittypes;

import mindustry.type.UnitType;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.world.meta.Env;

import static galaxite.content.GalaxiteItems.magmaticCrystal;
import static galaxite.content.GalaxiteUtils.magmaticOutline;

public class MagmaticUnitType extends UnitType {
    public MagmaticUnitType(String name){
        super(name);
        outlineColor = magmaticOutline;
        envDisabled = Env.none;
        ammoType = new ItemAmmoType(magmaticCrystal);
        researchCostMultiplier = 5;
    }
}