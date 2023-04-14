package galaxite.content;

import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.*;
import galaxite.content.world.blocks.distribution.*;
import mindustry.world.blocks.units.UnitCargoLoader;
import mindustry.world.blocks.units.UnitCargoUnloadPoint;

import static galaxite.content.GalaxiteItems.*;
import static galaxite.content.GalaxiteUnitTypes.*;
import static galaxite.content.GalaxiteLiquids.*;
import static mindustry.type.ItemStack.with;

public class GalaxiteBlocks {
    public static Block

    //region distribution - Thrygatis

    scrapConveyor, scrapJunction, scrapBridge, scrapRouter, magmaticDuct, magmaticBridge, magmaticOverflowDuct, magmaticUnderflowDuct, magmaticRouter,

    //special distribution - Thrygatis

    deliveringPad, collectingPad;

    public static void load() {
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
            consumeLiquids(LiquidStack.with(magma, 6/60, aethephus , 6/60));
        }};

        collectingPad = new UnitCargoUnloadPoint("collecting-pad"){{
            requirements(Category.distribution, with(Items.graphite, 16, magmaticCrystal, 20));
            size = 2;
            itemCapacity = 100;
            researchCostMultiplier = 1.5f;
        }};
    }
}