package cn.milolab.xiaofang.service;

import cn.milolab.xiaofang.bean.business.BasketBO;
import cn.milolab.xiaofang.bean.entity.Goods;
import cn.milolab.xiaofang.bean.view.BasketItemsVO;
import cn.milolab.xiaofang.dao.GoodsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author milowang
 */
@Service
public class GoodsService {
    @Autowired
    GoodsDAO goodsDAO;

    public List<BasketItemsVO> getBasketItems(HttpSession session){
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

    public List<Goods> getAllGoods() {
        return goodsDAO.getAllGoods();
    }
}
