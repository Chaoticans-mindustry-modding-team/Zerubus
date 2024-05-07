package zerubus.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class ZerubusLiquids{
    public static Liquid
    
    oxygen

    public static void load(){

        oxygen = new Liquid("oxygen", Color.valueOf("00aa99")){{
            gas = true;
            barColor = Color.valueOf("00aa99");
            explosiveness = 1f;
            flammability = 1f;
        }};
    }
}
