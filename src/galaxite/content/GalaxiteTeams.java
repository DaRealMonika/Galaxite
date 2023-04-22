package galaxite.content;

import arc.graphics.Color;
import mindustry.game.Team;

public class GalaxiteTeams {
    public static Team yperia;

    public static void load() {
        yperia = Team.get(6);
        yperia.color.set(Color.valueOf("7fdbdf"));
        yperia.name = "yperia";
    }
}