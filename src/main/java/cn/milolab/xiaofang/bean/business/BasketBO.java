package cn.milolab.xiaofang.bean.business;

import cn.milolab.xiaofang.bean.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author milowang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketBO {
    /**
     * 购物车列表，由商品实例映射到商品数量
     */
    private Map<Goods, Integer> basketItems;
}
