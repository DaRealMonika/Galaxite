package galaxite.content;

import mindustry.content.*;
import mindustry.graphics.CacheLayer;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.*;
import galaxite.content.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;

import static galaxite.content.GalaxiteItems.*;
import static galaxite.content.GalaxiteUnitTypes.*;
import static galaxite.content.GalaxiteLiquids.*;
import static mindustry.type.ItemStack.with;

public class GalaxiteBlocks {
    public static Block

    //region environment - Thrygatis

    ashWall, ashFloor, ashBoulder, redGraphiticWall, magmaFloor, oreMagmaticCrystal, wallOreMagmaticCrystal,

    //turrets - Thrygatis

    duster, kamiskyzer,

    //defence - Thrygatis

    magmaticWall, magmaticWallLarge,

    //region distribution - Thrygatis

    scrapConveyor, scrapJunction, scrapBridge, scrapRouter, magmaticDuct, magmaticBridge, magmaticOverflowDuct, magmaticUnderflowDuct, magmaticRouter,

    //special distribution - Thrygatis

    deliveringPad, collectingPad,

    //production - Thrygatis

    ashCollector, scrapDrill, scrapBeamDrill, magmaticDrill, magmaticBeamDrill,

    //power - Thrygatis

    magmaticBeamNode, magmaticBeamNodeLarge, payloadDecayGenerator, liquidGenerator,

    //factories - Thrygatis

    magmaRefiner,

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

        ashBoulder = new Prop("ash_boulder"){{
            variants = 2;
        }};

        redGraphiticWall = new StaticWall("red-graphitic-wall"){{
            itemDrop = Items.graphite;
            variants = 3;
        }};

        oreMagmaticCrystal = new OreBlock("ore-magmatic-crystal");

        wallOreMagmaticCrystal = new OreBlock("wall-ore-magmatic-crystal"){{
            wallOre = true;
        }};

        magmaFloor = new Floor("magma-floor"){{
            speedMultiplier = 0.2f;
            variants = 2;
            status = StatusEffects.melting;
            statusDuration = 240f;
            liquidDrop = magma;
            mapColor = magma.color;
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
            consumeLiquids(LiquidStack.with(magma, 0.1f, aethephus , 0.1f));
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
            requirements(Category.distribution, with(Items.scrap, 5, cinderAsh, 9));
            tier = 2;
            drillTime = 430f;
            size = 1;
            blockedItem = magmaticCrystal;
            consumeLiquid(Liquids.water, 0.04f).boost();
        }};

        scrapBeamDrill = new BeamDrill("scrap-beam-drill"){{
            requirements(Category.distribution, with(Items.scrap, 5, cinderAsh, 9));
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
            requirements(Category.distribution, with(Items.graphite, 10, magmaticCrystal, 18));
            tier = 2;
            drillTime = 400f;
            size = 2;
            consumeLiquid(Liquids.water, 0.04f).boost();
        }};

        magmaticBeamDrill = new BeamDrill("magmatic-beam-drill"){{
            requirements(Category.distribution, with(Items.scrap, 16, magmaticCrystal, 18));
            tier = 2;
            drillTime = 120/0.5f;
            optionalBoostIntensity = 4f;
            size = 2;
            range = 7;
            fogRadius = 3;
            consumePower(0.06f);
            consumeLiquid(Liquids.water, 0.04f).boost();
        }};

        magmaRefiner = new GenericCrafter("magma-refiner"){{
            requirements(Category.crafting, with(Items.scrap, 25, Items.graphite, 10, magmaticCrystal, 25));
            outputItem = new ItemStack(obsidian, 1);
            craftTime = 180f;
            size = 2;
            hasPower = true;
            hasLiquids = true;
            hasItems = true;
            consumePower(70f/60f);
            consumeLiquid(magma, 0.2f);
        }};

        aeriaton = new CoreBlock("aeriaton"){{
            requirements(Category.effect, with(Items.scrap, 350, magmaticCrystal, 500));
            isFirstTier = true;
            unitType = venture;
            health = 950;
            itemCapacity = 2500;
            size = 2;
            unitCapModifier = 4;
        }};

        celestial = new CoreBlock("celestial"){{
            requirements(Category.effect, with(Items.scrap, 1));
            unitType = unit1;
            health = 5500;
            armor = 3f;
            itemCapacity = 12000;
            size = 3;
            unitCapModifier = 24;
            buildVisibility = BuildVisibility.hidden;
        }};

        aether = new CoreBlock("aether"){{
            requirements(Category.effect, with(Items.scrap, 1));
            unitType = unit2;
            size = 4;
            health = 8800;
            armor = 5;
            itemCapacity = 17500;
            unitCapModifier = 36;
            buildVisibility = BuildVisibility.hidden;
        }};
    }
}