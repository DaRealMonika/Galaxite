package galaxite;

import arc.*;
import arc.util.*;
import mindustry.Vars;
import mindustry.game.*;
import mindustry.mod.*;
import galaxite.content.*;
import mindustry.ui.dialogs.*;
import mindustry.world.meta.*;

import static java.lang.Boolean.*;

public class GalaxiteMod extends Mod{

    public GalaxiteMod() {
        Attribute.add("ash");
    }

    @Override
    public void loadContent(){
        GalaxiteItems.load();
        GalaxiteLiquids.load();
        GalaxiteStatus.load();
        GalaxiteUnitTypes.load();
        GalaxiteWeather.load();
        GalaxiteBlocks.load();
        GalaxiteTeams.load();
        GalaxitePlanets.load();
        GalaxiteSectors.load();
        GalaxiteTechTree.load();

        var mod = Vars.modDirectory.child("galaxite").child("main.txt");
        if (!mod.exists() || (!mod.readString().equals("true") || !mod.readString().equals("false"))) mod.writeString("false");
        var hidden = parseBoolean(mod.readString());

        Events.on(EventType.ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog(Core.bundle.get("menu.galdaxite-report"));
                dialog.cont.pane(table -> {
                            table.image(Core.atlas.find("galaxite-planet")).color(GalaxitePlanets.vopovin.iconColor).size(64, 64).pad(3).row();

                            table.add(Core.bundle.get("menu.galaxite-report-1.sub")).left().growX().wrap().width(420).maxWidth(420).pad(4).labelAlign(Align.left).row();

                            table.add(Core.bundle.get("menu.galaxite-report-2.sub")).left().growX().wrap().width(420).maxWidth(420).pad(4).labelAlign(Align.left).row();
                });
                dialog.buttons.button(Core.bundle.get("menu.galaxite-hideMenu"), () -> {
                    dialog.hide();
                    mod.writeString("true");
                }).size(210f, 64f);
                dialog.buttons.button("@close", dialog::hide).size(210, 64);
                if (!hidden) dialog.show();
            });
        });
    }

}