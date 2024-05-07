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
crimsonGrass, zeruvianSoil, zeruvianStone, bloodSoil,
//static walls
crimsonGrassWall, zeruvianSoilWall, zeruvianStoneWall,
//ores
silverOre, indiumOre, silicateWallOre,
//walls
silverWall, silverWallLarge,
//distribution
silverDuct, silverJunction, silverRouter,
//drills
silverDrill, silverPlasmaBore,
//power
silverNode, indiumNode, silverBattery, coalTurbine,
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

        bloodSoil = new Floor("blood-soil"){{
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

        silicateWallOre = new OreBlock(ZerubusItems.silicate){{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
            wallOre = true;
        }};

        silicateForge = new GenericCrafter("silicate-forge"){{
            requirements(Category.crafting, with(ZerubusItems.silver, 40, ZerubusItems.indium, 60));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.silicon, 5);
            outputLiquid = new liquidStack(ZerubusLiquids.oxygen, 0.2);
            craftTime = 40f;
            size = 3;
            hasPower = true;
            hasLiquids = true;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(Items.coal, 5, ZerubusItems.silicate, 5));
            consumePower(0.50f);
        }};
        
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

        silverNode = new PowerNode("silver-node"){{
            requirements(Category.power, with(ZerubusItems.silver, 10));
            maxNodes = 15;
            laserRange = 8;
            size = 2;
        }};

        silverBattery = new Battery("silver-battery"){{
            requirements(Category.power, with(ZerubusItems.silver, 20, ZerubusItems.indium, 5));
            consumePowerBuffered(2500f);
            baseExplosiveness = 1f;
            size = 2;
        }};

        coalTurbine = new ConsumeGenerator("coal-turbine"){{
            requirements(Category.power, with(ZerubusItems.silver, 40, ZerubusItems,indium, 10));
            powerProduction = 1f;
            itemDuration = 120f;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
            generateEffect = Fx.generatespark;

            consume(new ConsumeItemFlammable());
            consume(new ConsumeItemExplode());

            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
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
   
