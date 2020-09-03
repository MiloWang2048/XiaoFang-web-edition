package cn.milolab.xiaofang;

import cn.milolab.xiaofang.bean.entity.Goods;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Playground {
    @Test
    public void test(){
        var g1 = new Goods(1,"g1",20.0,true);
        var g2 = new Goods(2,"g2",15.0,false);
        var map = new HashMap<Goods, Integer>();
        map.put(g1, 1);
        map.put(g2, 2);
        System.out.println(map);
    }
}
