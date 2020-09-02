package cn.milolab.xiaofang.controller;

import cn.milolab.xiaofang.bean.business.BasketBO;
import cn.milolab.xiaofang.bean.request.AddToCartRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author milow
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {
    @PostMapping("add_to_basket")
    public void addToBasket(@RequestBody AddToCartRequest request, HttpSession session) {
        var basket = (BasketBO) session.getAttribute("basket");
        var items = basket.getBasketItems();
        var goodsId = request.getGoodsId();
        items.put(goodsId, items.getOrDefault(goodsId, 0) + 1);
        basket.setBasketItems(items);
        session.setAttribute("basket", basket);
    }

    @PostMapping("clear_basket")
    public void clearBasket( HttpSession session) {
        var basket = (BasketBO) session.getAttribute("basket");
        basket.setBasketItems(new HashMap<>());
    }
}
