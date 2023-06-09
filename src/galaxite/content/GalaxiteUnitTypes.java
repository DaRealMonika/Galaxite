package galaxite.content;

import galaxite.content.abilities.*;
import galaxite.content.unittypes.*;
import mindustry.ai.types.*;
import mindustry.gen.*;
import mindustry.type.*;

public class GalaxiteUnitTypes {
    public static UnitType

    //core - Thrygatis

    ventur, passage, paradise,

    //special tether - Thrygatis

    heliDrop, comet;

    public static void load(){
        ventur = new MagmaticUnitType("ventur"){{
            aiController = BuilderAI::new;
            isEnemy = false;
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
            fogRadius = 0f;
            range = 5f;
        }};
        ventur.abilities.add(new MendBuildings(30, 2.5f * 60f, ventur.range * 8));

        passage = new MagmaticUnitType("passage"){{
            aiController = BuilderAI::new;
            isEnemy = false;
            lowAltitude = true;
            flying = true;
            mineSpeed = 3.5f;
            mineHardnessScaling = true;
            mineTier = 2;
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
            fogRadius = 0f;
            range = 8f;
        }};
        passage.abilities.add(new HealUnits(30, 2.5f * 60f, passage.range * 8));

        paradise = new MagmaticUnitType("paradise"){{
            aiController = BuilderAI::new;
            isEnemy = false;
            lowAltitude = true;
            flying = true;
            mineSpeed = 3.5f;
            mineHardnessScaling = true;
            mineTier = 3;
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
            fogRadius = 0f;
            range = 16f;
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
            controller = u -> new CargoAI();
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