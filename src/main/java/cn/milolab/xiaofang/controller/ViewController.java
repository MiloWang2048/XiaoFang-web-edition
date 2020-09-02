package cn.milolab.xiaofang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author milow
 */
@Controller
public class ViewController {
    @GetMapping({"", "index"})
    public String indexView(Model model){
        model.addAttribute("hello", "hello, thymeleaf!");
        return "index";
    }

    @GetMapping({"/basket"})
    public String basketView(Model model){
        model.addAttribute("index", true);
        return "basket";
    }
}
