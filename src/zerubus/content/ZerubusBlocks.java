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

@SuppressWarnings("deprecation")
public class ZerubusBlocks{
    //walls
    public static Block 

//walls
silverWall, silverWallLarge,
//distribution
silverDuct, silverJunction, silverRouter,
//drills
silverDrill, silverPlasmaBore,
//cores
coreDire
;
    
    public static void load() {
        silverWall = new Wall("silver-wall"){{
            requirements(Category.defense, with(ZerubusItems.silver, 6));
            health = 600;
            envDisabled |= Env.scorching;
        }};

        silverWallLarge = new Wall("silver-wall-large"){{
            requirements(Category.defense, with(ZerubusItems.silver, 24));
            health = 2400;
            envDisabled |= Env.scorching;
        }};

        silverDuct = new StackConveyor("silver-duct"){{
            requirements(Category.distribution, with(ZerubusItems.silver, 3));
            health = 20;
            speed = 4f / 60f;
            itemCapacity = 15;
            solid = false;
        }};

        silverJunction = new Junction("silver-junction"){{
            requirements(Category.distribution, with(ZerubusItems.silver, 2));
            speed = 30;
            capacity = 6;
            health = 30;
            buildCostMultiplier = 6f;
            solid = false;
        }};

        silverRouter = new DuctRouter("silver-router"){{
            requirements(Category.distribution, with(ZerubusItems.silver,2));
            health = 90;
            speed = 4f;
            regionRotated1 = 1;
            solid = false;
        }};

        silverDrill = new Drill("silver-drill"){{
            requirements(Category.production, with(ZerubusItems.silver, 20, ZerubusItems.indium, 10));
            tier = 1;
            drillTime = 600;
            size = 2;
            //mechanical drill doesn't work in space

            consumeLiquid(Liquids.water, 0.05f).boost();
        }}; 

        silverPlasmaBore = new BeamDrill("silver-plasma-bore"){{
            requirements(Category.production, with(ZerubusItems.silver, 20,ZerubusItems.indium, 20));
            consumePower(0.15f);

            drillTime = 600f;
            tier = 1;
            size = 2;
            range = 5;
            fogRadius = 3;
        }};

        coreDire = new CoreBlock("core-dire"){{
            requirements(Category.effect, with(ZerubusItems.silver, 1000, ZerubusItems.indium, 800));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = UnitTypes.alpha;
            health = 4000;
            itemCapacity = 4000;
            size = 4;

            unitCapModifier = 8;
        }};

    }
}
   
