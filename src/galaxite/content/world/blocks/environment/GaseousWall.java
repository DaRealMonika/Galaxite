package galaxite.content.world.blocks.environment;

import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;

import static galaxite.content.GalaxiteStatus.*;

public class GaseousWall extends StaticWall {
    public static StatusEffect effect;
    public static Liquid spreadGas;
    public static int spreadRadius = 3;

    public GaseousWall(String name){
        super(name);
        update = true;
    }

    public class GaseousWallBuild extends Building {
        private float counter = 0.0f;
        @Override
        public void updateTile() {
            super.updateTile();
            if (spreadGas != null && counter >= 1) {
                for(int i = -spreadRadius; i < spreadRadius; i++) {
                    for(int n = -spreadRadius; i < spreadRadius; n++) {
                        Tile tile = Vars.world.tileWorld(x + i, y + n);
                        if (tile != null && (tile.block() == Blocks.air || tile.block().underBullets)) {
                            spreadGas.vaporEffect.at(tile.x, tile.y);
                        }
                        counter = 0.0f;
                    }
                }
            }
            counter += 0.05;
            Units.nearby(x, y, spreadRadius, spreadRadius, unit -> {
                if (unit.tileOn() != null && (unit.tileOn().block() == Blocks.air || unit.tileOn().block().underBullets) && (unit instanceof Mechc || unit.type.lowAltitude)) {
                    unit.apply(infested);
                }
            });
        }
    }
}