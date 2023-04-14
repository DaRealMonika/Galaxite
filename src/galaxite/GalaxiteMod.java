package galaxite;

import mindustry.mod.*;
import galaxite.content.*;

public class GalaxiteMod extends Mod{

    public GalaxiteMod() {}

    @Override
    public void loadContent(){
        GalaxiteBlocks.load();
    }

}