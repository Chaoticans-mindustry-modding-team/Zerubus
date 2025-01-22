package zerubus.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import zerubus.content.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static zerubus.content.ZerubusItems.*;
import static zerubus.content.ZerubusLiquids.*;

@SuppressWarnings("deprecation")
public class ZerubusBlocks{
    //walls
    public static Block 

//floors n crap
crimsonGrass, zeruvianSoil, zeruvianStone, brimstoneFloor,
//static walls
crimsonGrassWall, zeruvianSoilWall, zeruvianStoneWall,
//ores
silverOre, indiumOre,
//factories

//walls

//turrets

//distribution

//drills

//power

//cores
coreDire
;
    
    public static void load() {

        crimsonGrass = new Floor("crimson-grass"){{
            attributes.set(Attribute.water, 0.1f);
            variants = 5;
        }};

        zeruvianSoil = new Floor("zeruvian-soil"){{
            variants = 4;
        }};

        zeruvianStone = new Floor("zeruvian-stone"){{
            variants = 4;
        }};

        brimstoneFloor = new Floor("brimstoneFloor"){{
        }};

        crimsonGrassWall = new StaticWall("crimson-grass-wall"){{
            variants = 3;
        }};

        zeruvianSoilWall = new StaticWall("zeruvian-soil-wall"){{
            variants = 3;
        }};

        zeruvianStoneWall = new StaticWall("zeruvian-stone-wall"){{
            variants = 3;
        }};

        silverOre = new OreBlock(ZerubusItems.silver){{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};

        indiumOre = new OreBlock(ZerubusItems.indium){{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};

        coreDire = new CoreBlock("core-dire"){{
            requirements(Category.effect, with(ZerubusItems.silver, 1000, ZerubusItems.indium, 800));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = UnitTypes.alpha;
            health = 4000;
            itemCapacity = 4000;
            size = 3;

            unitCapModifier = 8;
        }};

    }
}
   
