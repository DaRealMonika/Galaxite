package galaxite.content;

import arc.graphics.Color;
import galaxite.content.world.planets.*;
import mindustry.Vars;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import mindustry.type.Weather;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;

import static galaxite.content.GalaxiteBlocks.*;
import static galaxite.content.GalaxiteItems.*;
import static galaxite.content.GalaxiteTeams.*;
import static galaxite.content.GalaxiteWeather.*;

public class GalaxitePlanets {
    public static Planet

    //system sun

    vopovin,

    //planets

    thrygatis;

    public static void load() {
        vopovin = new Planet("vopovin", Planets.sun, 8){{
            meshLoader = () -> new SunMesh(vopovin,
                    4, 5, 0.3, 2, 1.2, 1, 1.1f,
                    Color.valueOf("ffffff"), Color.valueOf("d7d3c6"), Color.valueOf("e1ba45"), Color.valueOf("e0c470"), Color.valueOf("dd9f9c"), Color.valueOf("ac8d8b"));
            bloom = true;
            accessible = true;
            iconColor = Color.valueOf("e1ba45");
            alwaysUnlocked = true;
            unlocked = true;
        }};

        thrygatis = new Planet("thrygatis", vopovin, 1, 2){{
            generator = new ThrygatisPlanetGenerator();
            meshLoader = () -> new HexMesh(thrygatis, 2);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(thrygatis, 2, 0.15f, 0.14f, 5,
                            Color.valueOf("edb26fbf"), 2, 0.42f, 1, 0.43f)
            );
            atmosphereColor = Color.valueOf("824069");
            landCloudColor = Color.valueOf("3c7141");
            solarSystem = vopovin;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.5f;
            camRadius = 0.5f;
            visible = true;
            bloom = false;
            accessible = true;
            alwaysUnlocked = true;
            allowLaunchLoadout = true;
            allowLaunchSchematics = false;
            launchCapacityMultiplier = 0.75f;
            clearSectorOnLose = true;
            startSector = 16;
            orbitRadius = 30f;
            rotateTime = 7 * 60;
            defaultCore = aeriaton;
            iconColor = Color.valueOf("c44b00");
            totalRadius += 2.6f;
            hiddenItems.addAll(Vars.content.items()).removeAll(thrygatisItems);
            defaultEnv = Env.scorching | Env.terrestrial;
            defaultAttributes.set(Attribute.heat, 1.7f);
            ruleSetter = r -> {
                r.waveTeam = yperia;
                r.onlyDepositCore = true;
                r.loadout = ItemStack.list(Items.scrap, 50, cinderAsh, 15);
                r.showSpawns = true;
                r.fog = true;
                r.solarMultiplier = 2f;
                r.coreDestroyClear = true;
                r.hideBannedBlocks = true;
                r.hiddenBuildItems.addAll(Vars.content.items());
                r.hiddenBuildItems.removeAll(thrygatisItems);
                if (r.sector.id != 16) r.weather.add(new Weather.WeatherEntry(moltenRain));
            };
            unlockedOnLand.add(aeriaton);
        }};

        Vars.content.planets().each(p -> {
            if (p == thrygatis) return;
            p.hiddenItems.addAll(thrygatisOnlyItems);
        });
        vopovin.parent = vopovin;
    }
}