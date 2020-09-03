package cn.milolab.xiaofang.bean.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author milowang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartRequest {
    /**
     * 要添加商品的id
     */
    private int goodsId;
}
