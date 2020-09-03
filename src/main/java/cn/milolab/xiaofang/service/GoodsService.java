package cn.milolab.xiaofang.service;

import cn.milolab.xiaofang.bean.business.BasketBO;
import cn.milolab.xiaofang.bean.entity.Goods;
import cn.milolab.xiaofang.bean.request.AddToCartRequest;
import cn.milolab.xiaofang.bean.business.BasketEntityBO;
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
     * 获取购物车实体列表
     *
     * @param session 用户session
     * @return 购物车实体列表
     */
    public List<BasketEntityBO> getBasketEntities(HttpSession session) {

        // 获取商品id到数量的映射
        var basket = ((BasketBO) session.getAttribute("basket")).getBasketItems();

        // 创建一个结果列表
        var items = new ArrayList<BasketEntityBO>();

        // 由映射创建实体列表并返回
        for (var i : basket.keySet()) {
            var item = new BasketEntityBO();
            var goods = goodsDAO.findById(i);
            item.setGoods(goods);
            item.setAmount(basket.get(i));
            items.add(item);
        }
        return items;
    }

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
        var basketEntities = getBasketEntities(session);

        // 计算总价格
        var sum = 0.0;
        for (var info : basketEntities) {
            sum += info.getAmount() * info.getGoods().getPrice();
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

        // 提取请求中的商品ID
        var goodsId = request.getGoodsId();

        // 在映射中增加物品
        items.put(goodsId, items.getOrDefault(goodsId, 0) + 1);
    }
}
