package galaxite;

import mindustry.mod.*;
import galaxite.content.*;

public class GalaxiteMod extends Mod{

    public GalaxiteMod() {}

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
        GalaxiteSctors.load();
        GalaxiteTechTree.load();
    }

}