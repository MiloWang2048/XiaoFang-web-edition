package cn.milolab.xiaofang.controller;

import cn.milolab.xiaofang.bean.business.BasketBO;
import cn.milolab.xiaofang.bean.request.AddToCartRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author milow
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @PostMapping("add_to_basket")
    public void addToBasket(@RequestBody AddToCartRequest request, HttpSession session) {
        var basket = (BasketBO) session.getAttribute("basket");
        var items = basket.getBasketItems();
        var goodsId = request.getGoodsId();
        items.put(goodsId, items.getOrDefault(goodsId,0) + 1);
        System.out.println(session.getAttribute("basket"));
    }
}
