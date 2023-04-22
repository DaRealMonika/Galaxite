package galaxite.content;

import arc.func.*;
import arc.struct.*;
import mindustry.content.*;
import mindustry.content.TechTree.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static galaxite.content.GalaxiteBlocks.*;
import static galaxite.content.GalaxiteItems.*;
import static galaxite.content.GalaxiteLiquids.*;
import static galaxite.content.GalaxiteWeather.*;
import static mindustry.content.TechTree.*;

public class GalaxiteTechTree {
    static TechTree.TechNode context = null;

    public static void load() {
        node(moltenRain);

        nodeProduce(Items.scrap, () -> {
            nodeProduce(cinderAsh, () -> {
                nodeProduce(Items.graphite, () -> {
                    nodeProduce(magmaticCrystal, () -> {
                        nodeProduce(metallicDust, () -> {});
                        nodeProduce(Liquids.slag, () -> {
                            nodeProduce(aethephus, () -> {});
                        });
                        nodeProduce(magma, () -> {
                            nodeProduce(obsidian, () -> {});
                        });
                    });
                });
            });
        });
        
        node(aeriaton, () -> {
            node(celestial, () -> {
                node(aether);
            });
        });


        node(scrapConveyor, () -> {
            node(magmaticDuct, () -> {
                node(magmaticBridge, () -> {});
                node(magmaticRouter, Seq.with(
                        new Research(scrapRouter)), () -> {
                    node(magmaticOverflowDuct, () -> {
                        node(magmaticUnderflowDuct, () -> {});
                    });
                });
            });
            node(scrapJunction, () -> {
                node(scrapRouter, () -> {});
                node(scrapBridge, () -> {});
            });
        });
        node(ashCollector, () -> {
            node(scrapDrill, () -> {
                node(magmaticDrill, Seq.with(
                        new Research(magmaticBeamDrill)), () -> {});
                node(scrapBeamDrill, () -> {
                    node(magmaticBeamDrill, () -> {});
                });
            });
        });
        node(duster, () -> {
            node(kamiskyzer, () -> {});
        });
        node(magmaticWall, () -> {
            node(magmaticWallLarge, () -> {});
        });
        node(payloadDecayGenerator, () -> {
            node(magmaticBeamNode, () -> {
                node(magmaticBeamNodeLarge, () -> {});
            });
            node(liquidGenerator, () -> {});
            node(magmaRefiner, () -> {});
        });
    }
}