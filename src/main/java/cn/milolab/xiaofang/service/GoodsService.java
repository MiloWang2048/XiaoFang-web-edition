package cn.milolab.xiaofang.service;

import cn.milolab.xiaofang.bean.business.BasketBO;
import cn.milolab.xiaofang.bean.entity.Goods;
import cn.milolab.xiaofang.bean.request.AddToCartRequest;
import cn.milolab.xiaofang.dao.GoodsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author milowang
 */
@Service
public class GoodsService {
    @Autowired
    GoodsDAO goodsDAO;

    /**
     * 清除购物车
     *
     * @param session 用户session
     */
    public void clearBasketItems(HttpSession session) {
        var basket = (BasketBO) session.getAttribute("basket");
        basket.setBasketItems(new HashMap<>());
    }

    /**
     * 结算购物车
     *
     * @param session 用户session
     * @return 总价格
     */
    public double checkout(HttpSession session) {

        // 获取商品实体列表
        var basket = ((BasketBO)session.getAttribute("basket")).getBasketItems();

        // 计算总价格
        var sum = 0.0;
        for (var info : basket.keySet()) {
            sum += info.getPrice() * basket.get(info);
        }

        // 清空购物车
        clearBasketItems(session);
        return sum;
    }

    /**
     * 获取所有商品
     *
     * @return 商品实体列表
     */
    public List<Goods> getAllGoods() {
        return goodsDAO.getAllGoods();
    }

    /**
     * 添加商品到购物车
     *
     * @param request 用户请求
     * @param session 用户session
     */
    public void addToBasket(AddToCartRequest request, HttpSession session) {

        // 获取购物车对象
        var basket = (BasketBO) session.getAttribute("basket");

        // 获取商品数量映射
        var items = basket.getBasketItems();

        // 提取请求中的商品的实体
        var goods = goodsDAO.findById(request.getGoodsId());

        // 在映射中增加物品
        items.put(goods, items.getOrDefault(goods, 0) + 1);
    }
}
