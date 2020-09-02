package cn.milolab.xiaofang.controller;

import cn.milolab.xiaofang.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author milow
 */
@Controller
@Slf4j
public class ViewController {
    @Autowired
    GoodsService goodsService;

    @GetMapping({"", "/store"})
    public String indexView(Model model){
        model.addAttribute("goodsList", goodsService.getAllGoods());
        return "index";
    }

    @GetMapping({"/basket"})
    public String basketView(Model model, HttpSession session){
        model.addAttribute("basket", goodsService.getBasketItemsInfo(session));
        return "basket";
    }
}
