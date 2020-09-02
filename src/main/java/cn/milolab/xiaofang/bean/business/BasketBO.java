package cn.milolab.xiaofang.bean.business;

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
    private Map<Integer, Integer> basketItems;
}
