package cn.milolab.xiaofang.controller;

import cn.milolab.xiaofang.bean.entity.Goods;
import cn.milolab.xiaofang.dao.GoodsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author milow
 */
@Controller
public class ViewController {
    @Autowired
    GoodsDAO goodsDAO;

    @GetMapping({"", "/store"})
    public String indexView(Model model){
        model.addAttribute("goodsList", goodsDAO.getAllGoods());
        return "index";
    }

    @GetMapping({"/basket"})
    public String basketView(Model model){
        return "basket";
    }
}
