package galaxite.content;

import arc.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.*;

import static mindustry.type.ItemStack.with;

//import galaxite.world.blocks.distribution.*;
public class GalaxiteBlocks {
    public static Block

    //region distribution - Thrygatis

    scrapConveyor, scrapJunction, scrapBridge, scrapRouter;

    public static void load() {
        scrapConveyor = new Conveyor("scrap-conveyor"){{
            requirements(Category.distribution, with(Items.scrap, 1));
            health = 30;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            researchCost = with(Items.scrap, 5);
            junctionReplacement = scrapJunction;
            bridgeReplacement = scrapBridge;
        }};

        scrapJunction = new Junction("scrap-junction"){{
            requirements(Category.distribution, with(Items.scrap, 2));
            health = 30;
            speed = 20;
            capacity = 2;
            buildCostMultiplier = 4f;
        }};

        scrapBridge = new BufferedItemBridge("scrap-bridge"){{
            requirements(Category.distribution, with(Items.scrap, 6));
            range = 3;
            arrowSpacing = 3f;
            speed = 20f;
            bufferCapacity = 8;
        }};

        scrapRouter = new Router("scrap=router"){{
            requirements(Category.distribution, with(Items.scrap, 3));
            health = 30;
            buildCostMultiplier = 3f;
        }};
    }
}