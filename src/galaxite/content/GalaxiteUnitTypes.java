package galaxite.content;

import mindustry.content.UnitTypes;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;

public class GalaxiteUnitTypes {
    public static UnitType

    heliDrop;

    public static void load(){
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
            constructor = UnitTypes.manifold.constructor;
        }};
    }
}