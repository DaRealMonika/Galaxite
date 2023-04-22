package galaxite.content;

import galaxite.content.abilities.HealUnits;
import galaxite.content.abilities.MendBuildings;
import mindustry.ai.types.BuilderAI;
import mindustry.gen.BuildingTetherPayloadUnit;
import mindustry.gen.Sounds;
import mindustry.gen.TimedKillUnit;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;

import static galaxite.content.GalaxiteUtils.*;

public class GalaxiteUnitTypes {
    public static UnitType

    //core - Thrygatis

    ventur, passage, paradise,

    //special tether - Thrygatis

    heliDrop, comet;

    public static void load(){
        ventur = new UnitType("ventur"){{
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
        ventur.abilities.add(new MendBuildings(30, 2.5f * 60f, ventur.range * 8));

        passage = new UnitType("passage"){{
            aiController = BuilderAI::new;
            constructor = UnitEntity::create;
        }};
        passage.abilities.add(new HealUnits(30, 2.5f * 60f, passage.range * 8));

        paradise = new UnitType("paradise"){{
            aiController = BuilderAI::new;
            constructor = UnitEntity::create;
        }};
        paradise.abilities.addAll(new MendBuildings(30, 2.5f * 60f, paradise.range * 8), new HealUnits(30, 2.5f * 60f, paradise.range * 8));

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