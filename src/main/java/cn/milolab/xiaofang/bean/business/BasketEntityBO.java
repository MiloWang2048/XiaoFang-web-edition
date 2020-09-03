package cn.milolab.xiaofang.bean.business;

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
public class BasketEntityBO {
    private Goods goods;
    private Integer amount;
}
