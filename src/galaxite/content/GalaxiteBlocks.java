package galaxite.content;

import galaxite.content.world.blocks.environment.*;
import galaxite.content.world.blocks.power.*;
import galaxite.content.world.blocks.walls.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.Sounds;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import galaxite.content.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static galaxite.content.GalaxiteItems.*;
import static galaxite.content.GalaxiteStatus.*;
import static galaxite.content.GalaxiteUnitTypes.*;
import static galaxite.content.GalaxiteLiquids.*;
import static galaxite.content.GalaxiteUtils.*;
import static mindustry.type.ItemStack.*;

public class GalaxiteBlocks {
    public static Block

    //region environment - Thrygatis

    ashWall, ashFloor, ashBoulder, redGraphiticWall, magmaFloor, oreMagmaticCrystal, wallOreMagmaticCrystal, ferventilisSporesWall,

    //turrets - Thrygatis

    duster, kamiskyzer, suffuse,

    //defence - Thrygatis

    magmaticWall, magmaticWallLarge,

    //region distribution - Thrygatis

    scrapConveyor, scrapJunction, scrapBridge, scrapRouter, magmaticDuct, magmaticBridge, magmaticOverflowDuct, magmaticUnderflowDuct, magmaticRouter,

    //special distribution - Thrygatis

    deliveringPad, collectingPad,

    //production - Thrygatis

    ashCollector, scrapDrill, scrapBeamDrill, magmaticDrill, magmaticBeamDrill,

    //units - Thrygatis

    magmaticPayloadConveyor, magmaticPayloadRouter,

    //power - Thrygatis

    magmaticBeamNode, magmaticBeamNodeLarge, payloadDecayGenerator, magmaticPumpDynamo,

    //factories - Thrygatis

    magmaRefiner, crudeGrinder,

    //cores - Thrygatis

    aeriaton, celestial, aether;

    public static void load() {
        ashWall = new StaticWall("ash-wall");

        ashFloor = new Floor("ash-floor"){{
            itemDrop = cinderAsh;
            playerUnmineable = true;
            speedMultiplier = 0.75f;
            variants = 3;
            decoration = ashBoulder;
            wall = ashWall;
            attributes.set(Attribute.get("ash"), 1);
        }};

        ashBoulder = new Prop("ash-boulder"){{
            variants = 2;
        }};

        redGraphiticWall = new StaticWall("red-graphitic-wall"){{
            itemDrop = Items.graphite;
            variants = 3;
        }};

        oreMagmaticCrystal = new OreBlock("ore-magmatic-crystal"){{
            itemDrop = magmaticCrystal;
        }};

        wallOreMagmaticCrystal = new OreBlock("wall-ore-magmatic-crystal"){{
            itemDrop = magmaticCrystal;
            wallOre = true;
        }};

        magmaFloor = new Floor("magma-floor"){{
            speedMultiplier = 0.2f;
            variants = 2;
            status = StatusEffects.melting;
            statusDuration = 240f;
            liquidDrop = magma;
            mapColor = magma.color.cpy();
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.25f;
            supportsOverlay = false;
            liquidMultiplier = 0.3f;
            drownTime = 60*1.2f;
            damageTaken = 15f;
            emitLight = true;
            lightRadius = 40f;
            lightColor = Liquids.slag.lightColor;
        }};

        ferventilisSporesWall = new GaseousWall("red-gaseous-wall"){{
            effect = infested;
            spreadGas = ferventilisSpores;
            spreadRadius = 4;
        }};

        duster = new ItemTurret("duster"){{
            requirements(Category.turret, with(Items.scrap, 25, cinderAsh, 22));
            recoil = 2f;
            reload = 6f;
            range = 60;
            shootCone = 30f;
            targetAir = true;
            ammoUseEffect = Fx.none;
            consumeCoolant(0.15f);
            shootSound = Sounds.flame;
            drawer = new DrawTurret("reinforced-");
            ammo(
                    cinderAsh, new BulletType(3.35f, 10){{
                        ammoMultiplier = 3f;
                        shootEffect = Fx.shootSmallFlame;
                        collidesAir = true;
                    }}
            );
        }};

        kamiskyzer = new LaserTurret("kamiskyzer"){{
            requirements(Category.turret, with(Items.scrap, 1));
            size = 2;
            buildVisibility = BuildVisibility.hidden;
            consumeCoolant(0.1f);
            drawer = new DrawTurret("reinforced-");
        }};

        suffuse = new ItemTurret("suffuse"){{
            requirements(Category.turret, with(Items.scrap, 1));
            size = 3;
            buildVisibility = BuildVisibility.hidden;
            drawer = new DrawTurret("reinforced-");
        }};

        magmaticWall = new BurningWall("magmatic-wall"){{
            requirements(Category.defense, with(magmaticCrystal, 6));
            burning = false;
            damage = 0.1f;
            range = 2f;
            health = 400;
            armor = 1f;
            size = 1;
        }};

        magmaticWallLarge = new BurningWall("magmatic-wall-large"){{
            requirements(Category.defense, with(magmaticCrystal, 24));
            burning = true;
            range = 2f;
            health = 1800;
            armor = 1f;
            size = 2;
        }};

        scrapConveyor = new BadConveyor("scrap-conveyor"){{
            requirements(Category.distribution, with(Items.scrap, 1, cinderAsh, 1));
            health = 30;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            researchCost = with(Items.scrap, 5, cinderAsh, 5);
            junctionReplacement = scrapJunction;
            bridgeReplacement = scrapBridge;
        }};

        scrapJunction = new Junction("scrap-junction"){{
            requirements(Category.distribution, with(Items.scrap, 2, cinderAsh, 2));
            health = 30;
            speed = 20;
            capacity = 2;
            buildCostMultiplier = 4f;
        }};

        scrapBridge = new BufferedItemBridge("scrap-bridge"){{
            requirements(Category.distribution, with(Items.scrap, 6, cinderAsh, 6));
            range = 3;
            arrowSpacing = 3f;
            speed = 20f;
            bufferCapacity = 8;
        }};

        scrapRouter = new Router("scrap-router"){{
            requirements(Category.distribution, with(Items.scrap, 3, cinderAsh, 3));
            health = 30;
            buildCostMultiplier = 3f;
        }};

        magmaticDuct = new Duct("magmatic-duct"){{
            requirements(Category.distribution, with(Items.scrap, 1, magmaticCrystal, 1));
            health = 50;
            speed = 7f;
        }};

        magmaticBridge = new DuctBridge("magmatic-bridge"){{
            requirements(Category.distribution, with(Items.graphite, 4, magmaticCrystal, 5));
            buildCostMultiplier = 2f;
            researchCostMultiplier = 0.3f;
        }};

        magmaticRouter = new DuctRouter("magmatic-router"){{
            requirements(Category.distribution, with(Items.graphite, 3, magmaticCrystal, 3));
            health = 70;
            buildCostMultiplier = 3f;
        }};

        magmaticOverflowDuct = new OverflowDuct("magmatic-overflow-duct"){{
            requirements(Category.distribution, with(Items.graphite, 4, magmaticCrystal, 2));
        }};

        magmaticUnderflowDuct = new OverflowDuct("magmatic-underflow-duct"){{
            requirements(Category.distribution, with(Items.graphite, 4, magmaticCrystal, 2));
            invert = true;
        }};

        deliveringPad = new UnitCargoLoader("delivering-pad"){{
            requirements(Category.distribution, with(Items.graphite, 20, magmaticCrystal, 35));
            unitType = heliDrop;
            hasPower = true;
            hasLiquids = true;
            size = 3;
            researchCostMultiplier = 1.5f;
            consumePower(8/60f);
            consumeLiquids(LiquidStack.with(magma, 0.1f, scoriaVapor , 0.1f));
        }};

        collectingPad = new UnitCargoUnloadPoint("collecting-pad"){{
            requirements(Category.distribution, with(Items.graphite, 16, magmaticCrystal, 20));
            size = 2;
            itemCapacity = 100;
            researchCostMultiplier = 1.5f;
        }};

        ashCollector = new AttributeCrafter("ash-collector"){{
            requirements(Category.production, with(Items.scrap, 10));
            craftEffect = Fx.none;
            outputItem = new ItemStack(cinderAsh , 1);
            craftTime = 240f;
            size = 1;
            hasItems = true;
            hasLiquids = true;
            itemCapacity = 10;
            group = BlockGroup.drills;
            attribute = Attribute.get("ash");
            researchCostMultiplier = 0.1f;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawRegion("-rotator", 20, true),
                    new DrawRegion("-top")
            );
        }};

        scrapDrill = new Drill("scrap-drill"){{
            requirements(Category.production, with(Items.scrap, 5, cinderAsh, 9));
            tier = 2;
            drillTime = 430f;
            size = 1;
            blockedItem = magmaticCrystal;
            consumeLiquid(Liquids.water, 0.04f).boost();
        }};

        scrapBeamDrill = new BeamDrill("scrap-beam-drill"){{
            requirements(Category.production, with(Items.scrap, 5, cinderAsh, 9));
            tier = 2;
            drillTime = 180/0.5f;
            optionalBoostIntensity = 2f;
            size = 1;
            range = 4;
            fogRadius = 3;
            consumePower(0.06f);
            consumeLiquid(Liquids.water, 0.04f).boost();
        }};

        magmaticDrill = new Drill("magmatic-drill"){{
            requirements(Category.production, with(Items.graphite, 10, magmaticCrystal, 18));
            tier = 2;
            drillTime = 400f;
            size = 2;
            consumeLiquid(Liquids.water, 0.04f).boost();
        }};

        magmaticBeamDrill = new BeamDrill("magmatic-beam-drill"){{
            requirements(Category.production, with(Items.scrap, 16, magmaticCrystal, 18));
            tier = 2;
            drillTime = 120/0.5f;
            optionalBoostIntensity = 4f;
            size = 2;
            range = 7;
            fogRadius = 3;
            consumePower(0.06f);
            consumeLiquid(Liquids.water, 0.04f).boost();
        }};

        magmaticBeamNode = new BeamNode("magmatic-beam-node"){{
            requirements(Category.power, with(Items.graphite, 1, magmaticCrystal, 3));
            size = 1;
            range = 7;
            laserColor1 = magmaticCrystal.color;
            laserColor2 = magmaticOutline;
        }};

        magmaticBeamNodeLarge = new BeamNode("magmatic-beam-node-large"){{
            requirements(Category.power, with(Items.graphite, 5, magmaticCrystal, 10));
            size = 3;
            range = 17;
            laserColor1 = magmaticCrystal.color;
            laserColor2 = magmaticOutline;
        }};

        magmaticPayloadConveyor = new PayloadConveyor("magmatic-payload-conveyor"){{
            requirements(Category.units, with(magmaticCrystal, 10, obsidian, 30));
            size = 3;
            moveTime = 35f;
            canOverdrive = false;
            researchCostMultiplier = 5;
            underBullets = true;
        }};

        magmaticPayloadRouter = new PayloadRouter("magmatic-payload-router"){{
            requirements(Category.units, with(magmaticCrystal, 15, obsidian, 30));
            size = 3;
            moveTime = 35f;
            canOverdrive = false;
            researchCostMultiplier = 5;
            underBullets = true;
        }};

        payloadDecayGenerator = new PayloadDecayGenerator("payload-decay-generator"){{
            requirements(Category.power, with(Items.scrap, 50, cinderAsh, 36));
            maxPayloadSize = 3f;
            deconstructSpeed = 2.5f;
            size = 3;
            regionSuffix = "-magmatic";
        }};

        magmaticPumpDynamo = new PowerPump("magmatic-pump-dynamo"){{
            requirements(Category.power, with(Items.graphite, 25, magmaticCrystal, 40));
            powerProduction = 8f;
            pumpAmount = 5/60;
            size = 2;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawWarmupRegion(),
                    new DrawRegion("-turbine", 2f),
                    new DrawRegion("-top"),
                    new DrawLiquidRegion()
            );
            consumePower(0.3f);
        }};

        magmaRefiner = new GenericCrafter("magma-refiner"){{
            requirements(Category.crafting, with(Items.scrap, 25, Items.graphite, 10, magmaticCrystal, 25));
            outputItem = new ItemStack(obsidian, 1);
            craftEffect = Fx.smeltsmoke;
            craftTime = 180f;
            size = 2;
            hasPower = true;
            hasLiquids = true;
            hasItems = true;
            consumePower(70f/60f);
            consumeLiquid(magma, 0.2f);
        }};
        
        crudeGrinder = new GenericCrafter("crude-grinder"){{
            requirements(Category.crafting, with(Items.scrap, 30, magmaticCrystal, 15));
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(metallicDust, 3);
            craftTime = 90;
            size = 2;
            hasItems = true;
            consumeItem(Items.scrap, 1);
            consumePower(0.6f);
        }};

        aeriaton = new CoreBlock("aeriaton"){{
            requirements(Category.effect, with(Items.scrap, 350, magmaticCrystal, 500));
            isFirstTier = true;
            unitType = ventur;
            health = 950;
            itemCapacity = 2500;
            size = 2;
            unitCapModifier = 4;
            alwaysUnlocked = true;
        }};

        celestial = new CoreBlock("celestial"){{
            requirements(Category.effect, with(Items.scrap, 1));
            unitType = passage;
            health = 5500;
            armor = 3f;
            itemCapacity = 12000;
            size = 3;
            unitCapModifier = 24;
            buildVisibility = BuildVisibility.hidden;
        }};

        aether = new CoreBlock("aether"){{
            requirements(Category.effect, with(Items.scrap, 1));
            unitType = paradise;
            size = 4;
            health = 8800;
            armor = 5;
            itemCapacity = 17500;
            unitCapModifier = 36;
            buildVisibility = BuildVisibility.hidden;
        }};
    }
}