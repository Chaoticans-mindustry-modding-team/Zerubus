package zerubus.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;
import mindustry.content.*;

public class ZerubusItems{
    public static Item
    indium, silver 

    ;

    public static final Seq<Item> zerubusItems = new Seq<>();
    public static void load(){
        indium = new Item("indium", Color.valueOf("000080")){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};

        silver = new Item("silver", Color.valueOf("a0a0ac")){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};

        silicate = new Item("silicate", Color.valueOf("85a468")){{
          hardness = 1;
          cost = 0.5f;
          alwaysUnlocked = true;
      }};

      zerubusItems.addAll(
          silver, indium, silicate, silicon, coal
          );
    
    }
}

  
