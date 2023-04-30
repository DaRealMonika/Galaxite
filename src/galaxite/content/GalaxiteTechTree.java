package galaxite.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.game.Objectives.*;

import static galaxite.content.GalaxiteBlocks.*;
import static galaxite.content.GalaxiteItems.*;
import static galaxite.content.GalaxiteLiquids.*;
import static galaxite.content.GalaxitePlanets.*;
import static galaxite.content.GalaxiteWeather.*;
import static mindustry.content.TechTree.*;

public class GalaxiteTechTree {
    public static void load() {
        thrygatis.techTree = nodeRoot("Thrygatis", aeriaton, () -> {
            //weathers
            
            node(moltenRain);

            //resources
            
            nodeProduce(Items.scrap, () -> {
                nodeProduce(cinderAsh, () -> {
                    nodeProduce(Items.graphite, () -> {
                        nodeProduce(magmaticCrystal, () -> {
                            nodeProduce(metallicDust, () -> {
                            });
                            nodeProduce(Liquids.slag, () -> {
                                nodeProduce(aethephus, () -> {
                                });
                            });
                            nodeProduce(magma, () -> {
                                nodeProduce(obsidian, () -> {
                                });
                            });
                        });
                    });
                });
            });
            
            //cores

            /*node(celestial, () -> {
                node(aether);
            });*/

            //transportation
            
            node(scrapConveyor, () -> {
                node(magmaticDuct, () -> {
                    node(magmaticBridge, () -> {
                    });
                    node(magmaticRouter, Seq.with(
                            new Research(scrapRouter)), () -> {
                        node(magmaticOverflowDuct, () -> {
                            node(magmaticUnderflowDuct, () -> {
                            });
                        });
                    });
                });
                node(scrapJunction, () -> {
                    node(scrapRouter, () -> {
                    });
                    node(scrapBridge, () -> {
                    });
                });
            });
            
            //production
            
            node(ashCollector, () -> {
                node(scrapDrill, () -> {
                    node(magmaticDrill, Seq.with(
                            new Research(magmaticBeamDrill)), () -> {
                    });
                    node(scrapBeamDrill, () -> {
                        node(magmaticBeamDrill, () -> {
                        });
                    });
                });
            });
            
            //turrets
            
            node(duster, () -> {/*
                node(suffuse, () -> {
                    node(kamiskyzer, () -> {
                    });
                };*/
            });
            
            //defense
            
            node(magmaticWall, () -> {
                node(magmaticWallLarge, () -> {
                });
            });
            
            //power
            
            node(payloadDecayGenerator, () -> {
                node(magmaticBeamNode, () -> {
                    node(magmaticBeamNodeLarge, () -> {
                    });
                });
                node(magmaticPumpDynamo, () -> {
                });
            });
            
            //factories
            
            node(ashCompressor, () -> {
                node(magmaRefiner, Seq.with(
                        new Research(payloadDecayGenerator)), () -> {
                    node(crudeGrinder, () -> {
                        
                    });
                });
            });
        });
    }
}