package com.kaiwen.controller;

import com.kaiwen.bean.car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller和ResponseBody的合体
 */
@Controller
public class HelloController {

    @Autowired
    car nn;

    @RequestMapping("/hello")
    public String handle(Model model){
        model.addAttribute("msg", "你好");
        return "test1";
    }

    @RequestMapping("/")
    public String go(){
        return "test1";
    }

}
