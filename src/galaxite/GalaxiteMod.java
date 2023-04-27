package galaxite;

import mindustry.mod.*;
import galaxite.content.*;
import mindustry.world.meta.Attribute;

public class GalaxiteMod extends Mod{

    public GalaxiteMod() {
        Attribute.add("ash");
    }

    @Override
    public void loadContent(){
        GalaxiteItems.load();
        GalaxiteLiquids.load();
        GalaxiteStatus.load();
        GalaxiteUnitTypes.load();
        GalaxiteWeather.load();
        GalaxiteBlocks.load();
        GalaxiteTeams.load();
        GalaxitePlanets.load();
        GalaxiteSectors.load();
        GalaxiteTechTree.load();
    }

}