package cn.milolab.xiaofang.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author milowang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer id;
    private String name;
    private Double price;
    private Boolean isImported;

    /**
     * 商品名称的getter
     *
     * @return 处理后的名称
     */
    public String getName() {
        return isImported ? name + " <I>" : name;
    }

    /**
     * 商品价格getter
     *
     * @return 处理后的价格
     */
    public Double getPrice() {
        return isImported ? 1.2 * price : price;
    }
}
