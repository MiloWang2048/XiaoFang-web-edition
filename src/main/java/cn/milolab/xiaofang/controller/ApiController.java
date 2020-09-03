package cn.milolab.xiaofang.controller;

import cn.milolab.xiaofang.bean.business.BasketBO;
import cn.milolab.xiaofang.bean.request.AddToCartRequest;
import cn.milolab.xiaofang.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    GoodsService goodsService;

    /**
     * 添加一个商品到购物车
     *
     * @param request 用户请求
     * @param session 用户session
     */
    @PostMapping("add_to_basket")
    public void addToBasket(@RequestBody AddToCartRequest request, HttpSession session) {
        goodsService.addToBasket(request, session);
    }

    /**
     * 清空购物车
     *
     * @param session 用户session
     */
    @PostMapping("clear_basket")
    public void clearBasket(HttpSession session) {
        goodsService.clearBasketItems(session);
    }

    /**
     * 结算
     *
     * @param session 用户session
     * @return 总价格
     */
    @PostMapping("checkout")
    public double checkout(HttpSession session) {
        return goodsService.checkout(session);
    }
}
