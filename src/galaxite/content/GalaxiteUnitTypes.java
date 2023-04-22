package galaxite.content;

import galaxite.content.abilities.HealUnits;
import galaxite.content.abilities.MendBuildings;
import mindustry.ai.types.BuilderAI;
import mindustry.content.UnitTypes;
import mindustry.gen.BuildingTetherPayloadUnit;
import mindustry.gen.Sounds;
import mindustry.gen.TimedKillUnit;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;

import static galaxite.content.GalaxiteUtils.*;

public class GalaxiteUnitTypes {
    public static UnitType

    //core - Thrygatis

    venture, unit1, unit2,

    //special tether - Thrygatis

    heliDrop, comet;

    public static void load(){
        venture = new UnitType("venture"){{
            aiController = BuilderAI::new;
            isEnemy = false;
            outlineColor = magmaticOutline;
            lowAltitude = true;
            flying = true;
            mineSpeed = 3.5f;
            mineHardnessScaling = true;
            mineTier = 1;
            buildSpeed = 1.5f;
            drag = 0.05f;
            speed = 2.3f;
            rotateSpeed = 5f;
            accel = 0.1f;
            itemCapacity = 30;
            health = 100;
            engineOffset = 6;
            hitSize = 12f;
            alwaysUnlocked = true;
            coreUnitDock = true;
            constructor = UnitEntity::create;
            envDisabled = 0;
            fogRadius = 0f;
            range = 5f;
        }};
        venture.abilities.add(new MendBuildings(30, 2.5f * 60f, venture.range * 8));

        unit1 = new UnitType("unit1"){{
            aiController = BuilderAI::new;
            constructor = UnitEntity::create;
        }};
        unit1.abilities.add(new HealUnits(30, 2.5f * 60f, unit1.range * 8));

        unit2 = new UnitType("unit2"){{
            aiController = BuilderAI::new;
            constructor = UnitEntity::create;
        }};
        unit2.abilities.addAll(new MendBuildings(30, 2.5f * 60f, unit2.range * 8), new HealUnits(30, 2.5f * 60f, unit2.range * 8));

        heliDrop = new UnitType("heli-drop"){{
            isEnemy = false;
            flying = true;
            drag = 0.06f;
            speed = 3f;
            rotateSpeed = 9f;
            accel = 0.1f;
            itemCapacity = 100;
            health = 150;
            engineOffset = 4;
            hitSize = 8f;
            allowedInPayloads = false;
            logicControllable = false;
            playerControllable = false;
            envDisabled = 0;
            payloadCapacity = 0f;
            constructor = BuildingTetherPayloadUnit::create;
        }};

        comet = new UnitType("comet"){{
            speed = 0;
            isEnemy = false;
            envDisabled = 0;
            targetable = false;
            hittable = false;
            playerControllable = false;
            createWreck = false;
            createScorch = true;
            logicControllable = false;
            useUnitCap = false;
            allowedInPayloads = false;
            constructor = TimedKillUnit::create;
            physics = false;
            bounded = false;
            hidden = true;
            lifetime = (float)60*8;
            health = 10000f;
            drawMinimap = false;
            flying = true;
            drawCell = false;
            deathSound = Sounds.none;
        }};
    }
}