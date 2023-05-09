package galaxite.content.world.blocks.turrets;

import arc.Core;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.entities.Units;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.ui.Bar;
import mindustry.ui.Fonts;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;

public class UnitLaserTurret extends LaserTurret { // TODO finish me
    public static UnitType unitType;
    public static float unitConsPower;
    public static int unitCap;
    public static float buildTime = 60;
    public static float polyStroke = 1.8f, polyRadius = 8f;
    public static int polySides = 6;
    public static float polyRotateSpeed = 1f;

    public UnitLaserTurret(String name){
        super(name);
    }

    @Override
    public void setBars() {
        super.setBars();

        int u = 0;
        (UnitLaserTurretBuild e) -> {
            for (int i = 0; i < unitCap; i++) {
                if (e.unit[i] != null) u++;
            }
        }

        addBar("units", (UnitLaserTurretBuild e) ->
                new Bar(
                        () ->
                                Core.bundle.format("bar.unitcap",
                                        Fonts.getUnicodeStr(unitType.name),
                                        u,
                                        unitCap
                                ),
                        () -> Pal.power,
                        () -> (float)u / unitCap
                ));
    }

    /*@Remote(called = Loc.server)
    public static void unitTetherBlockSpawned(Tile tile, int id){
        if(tile == null || !(tile.build instanceof UnitTetherBlock build)) return;
        build.spawned(id);
    }*/

    public class UnitLaserTurretBuild extends LaserTurretBuild/* implements UnitTetherBlock*/{
        public int[] readUnitId;
        public float buildProgress, totalProgress;
        public float warmup, readyness;
        public @Nullable Unit[] unit;
        public int cap = unitCap;

        @Override
        public void placed() {
            super.placed();
            for (int i = 1; i < cap + 1; i++) {
                readUnitId[i] = -1;
            }
        }

/*        @Override
        public void updateTile() {
            super.updateTile();
            //unit was lost/destroyed
            for (int i = 1; i < cap + 1; i++) {
                if (unit[i] != null && (unit[i].dead || !unit[i].isAdded())) {
                    unit[i] = null;
                }

                if (readUnitId[i] != -1) {
                    unit[i] = Groups.unit.getByID(readUnitId[i]);
                    if (unit[i] != null || !net.client()) {
                        readUnitId[i] = -1;
                    }
                }
            }

            warmup = Mathf.approachDelta(warmup, 1, 1 / 60);
            readyness = Mathf.approachDelta(readyness, 1, 1 / 60);

            int count = 0;
            for (int i = 1; i < cap + 1; i++) {
                if (unit[i] == null)
            }

            if((unit[1] == null || unit[2] == null || unit[3] == null)){
                buildProgress += edelta() / buildTime;
                totalProgress += edelta();

                if(buildProgress >= 1f){
                    if(!net.client()){
                        unit = unitType.create(team);
                        if(unit instanceof BuildingTetherc bt){
                            bt.building(this);
                        }
                        unit.set(x, y);
                        unit.rotation = 90f;
                        unit.add();
                        Call.unitTetherBlockSpawned(tile, unit.id);
                    }
                }
            }
        }*/

        @Override
        public void draw() {
            super.draw();
            Draw.draw(Layer.blockOver, () -> {
                Drawf.construct(this, unitType.fullIcon, 0, buildProgress, warmup, totalProgress);
            });
            Draw.z(Layer.bullet - 0.01f);
            Draw.color(team.color.cpy());
            Lines.stroke(polyStroke * readyness);
            Lines.poly(x, y, polySides, polyRadius, Time.time * polyRotateSpeed);
            Draw.reset();
            Draw.z(Layer.block);
        }
    }
}