package zerubus.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class ZerubusItems{
    public static Item
    indium, silver
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

  
