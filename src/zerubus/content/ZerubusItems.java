package zerubus.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;
import mindustry.content.*;

import static mindustry.content.Items.*;

public class ZerubusItems{
    public static Item
    indium, silver, silicate

    ;

    public static final Seq<Item> zerubusItems = new Seq<>();
    public static void load(){
        indium = new Item("indium", Color.valueOf("2a3581")){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};

        silver = new Item("silver", Color.valueOf("a0a0ac")){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};

        brimstone = new Item("brimstone", Color.valueOf("8a1f25")){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};

        quartz = new Item("quartz", Color.valueOf("addab8")){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};

      zerubusItems.addAll(
          silver, indium, brimstone, quartz, silicon, coal
          );
    
    }
}

  
