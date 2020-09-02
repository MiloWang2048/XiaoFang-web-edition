package cn.milolab.xiaofang.service;

import cn.milolab.xiaofang.bean.business.BasketBO;
import cn.milolab.xiaofang.bean.entity.Goods;
import cn.milolab.xiaofang.bean.view.BasketItemsVO;
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

    public List<BasketItemsVO> getBasketItemsInfo(HttpSession session){
        var basket = ((BasketBO)session.getAttribute("basket")).getBasketItems();
        var items = new ArrayList<BasketItemsVO>();
        for(var i : basket.keySet()){
            var item = new BasketItemsVO();
            var goods = goodsDAO.findById(i);
            item.setGoods(goods);
            item.setAmount(basket.get(i));
            items.add(item);
        }
        return items;
    }

    public void clearBasketItems(HttpSession session){
        var basket = (BasketBO) session.getAttribute("basket");
        basket.setBasketItems(new HashMap<>());
    }

    public double checkout(HttpSession session){
        var itemsInfo = getBasketItemsInfo(session);
        var sum = 0.0;
        for(var info : itemsInfo){
            sum += info.getAmount()*info.getGoods().getPrice();
        }
        clearBasketItems(session);
        return sum;
    }

    public List<Goods> getAllGoods() {
        return goodsDAO.getAllGoods();
    }
}
