package galaxite.content.world.planets;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.noise.Simplex;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.Sector;

public class ThrygatisPlanetGenerator extends SerpuloPlanetGenerator {
    @Override
    public boolean allowLanding(Sector sector){
        return false;
    }

    @Override
    public Color getColor(Vec3 position){
        var depth = Simplex.noise3d(6, 8, 0.56, 1.7, position.x, position.y, position.z) / 2;
        return Color.valueOf("c44b00").write(Color.valueOf("952f15")).lerp(Color.valueOf("ab8080"), Mathf.clamp(Mathf.round(depth, 0.25f)));
    }
}