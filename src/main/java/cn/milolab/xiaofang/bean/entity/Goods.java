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

    public String getName() {
        return isImported ? name + " <I>" : name;
    }

    public Double getPrice() {
        return isImported ? 1.2 * price : price;
    }
}
