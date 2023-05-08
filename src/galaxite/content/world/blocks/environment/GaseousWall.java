package galaxite.content.world.blocks.environment;

import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;

public class GaseousWall extends StaticWall {
    public static StatusEffect effect;
    public static Liquid spreadGas;
    public static int spreadRadius = 3;

    public GaseousWall(String name){
        super(name);
        update = true;
        underBullets = true;
        destructible = false;
        targetable = false;
    }

    public class GaseousWallBuild extends Building {
//        private float counter = 0.0f;

        @Override
        public void updateTile() {
            super.updateTile();
            if (spreadGas != null/* && counter >= 1*/) {
                for(float i = -spreadRadius; i < spreadRadius; i++) {
                    for(float n = -spreadRadius; n < spreadRadius; n++) {
                        Tile tile = Vars.world.tileWorld(x + i, y + n);
                        if (tile != null && (tile.block() == Blocks.air || tile.block().underBullets)) {
                            spreadGas.vaporEffect.at(tile.x, tile.y);
//                            Log.info("spread gas vfx");
                        }
//                        counter = 0.0f;
                    }
                }
                Units.nearby(x, y, spreadRadius * Vars.tilesize, spreadRadius * Vars.tilesize, unit -> {
                    if (unit.tileOn() != null && (unit.tileOn().block() == Blocks.air || unit.tileOn().block().underBullets) && unit.elevation <= 0.5f) {
                        unit.apply(effect);
                    }
                });
            }
//            counter += 0.05;
        }

        @Override
        public float handleDamage(float amount) {
            return 0;
        }

        @Override
        public boolean allowUpdate() {
            return true;
        }
    }
}