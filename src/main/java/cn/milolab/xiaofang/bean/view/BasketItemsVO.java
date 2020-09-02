package cn.milolab.xiaofang.bean.view;

import cn.milolab.xiaofang.bean.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author milowang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketItemsVO {
    private Goods goods;
    private Integer amount;
}
