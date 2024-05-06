package mindustry.content;

import arc.func.*;
import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.graphics.g3d.*;
import mindustry.graphics.g3d.PlanetGrid.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import zerubus.content.*;

public class Planets{
    public static ZerubusPlanet
    cataclysm,
    zerubus
    ;
    public static void load(){
        cataclysm = new Planet("cataclysm", null, 4f){{
            bloom = true;
            accessible = false;

            meshLoader = () -> new SunMesh(
                this, 4,
                5, 0.3, 1.7, 1.2, 1,
                1.1f,
                Color.valueOf("ff5438"),
                Color.valueOf("ff6224"),
                Color.valueOf("ff6346"),
                Color.valueOf("ff7547"),
                Color.valueOf("ff8546"),
                Color.valueOf("f49878")
            );
        }};

        zerubus = new Planet("zerubus", cataclysm, 1f, 2){{
            generator = new ErekirPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 2, 0.15f, 0.14f, 5, Color.valueOf("eba768").a(0.75f), 2, 0.42f, 1f, 0.43f),
                new HexSkyMesh(this, 3, 0.6f, 0.15f, 5, Color.valueOf("eea293").a(0.75f), 2, 0.42f, 1.2f, 0.45f)
            );
            alwaysUnlocked = true;
            landCloudColor = Color.valueOf("ed6542");
            atmosphereColor = Color.valueOf("f07218");
            defaultEnv = Env.scorching | Env.terrestrial;
            startSector = 10;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            tidalLock = false;
            orbitSpacing = 2f;
            totalRadius += 2.6f;
            lightSrcTo = 0.5f;
            lightDstFrom = 0.2f;
            clearSectorOnLose = true;
            defaultCore = Blocks.coreDire;
            iconColor = Color.valueOf("ff9266");
            hiddenItems.addAll(Items.serpuloItems).addAll(Items.erekirItems);
            enemyBuildSpeedMultiplier = 0.4f;

            //TODO disallowed for now
            allowLaunchToNumbered = false;

            //TODO SHOULD there be lighting?
            updateLighting = false;

            ruleSetter = r -> {
                r.waveTeam = Team.blue;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.fog = true;
                r.staticFog = true;
                r.lighting = false;
                r.coreDestroyClear = true;
                r.onlyDepositCore = true;
            };

            unlockedOnLand.add(Blocks.coreDire);
        }};

    }
}
