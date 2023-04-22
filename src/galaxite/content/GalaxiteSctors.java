package galaxite.content;

import mindustry.type.SectorPreset;

import static galaxite.content.GalaxitePlanets.*;

public class GalaxiteSctors {
    public static SectorPreset

    //thrygatis
    dayBreak;

    public static void load() {
        dayBreak = new SectorPreset("day-break", thrygatis, 16){{
            captureWave = 10;
            difficulty = 1f;
            addStartingItems = false;
            alwaysUnlocked = true;
            startWaveTimeMultiplier = 3f;
        }};
    }
}