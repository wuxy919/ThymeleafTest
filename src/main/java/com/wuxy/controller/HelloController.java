package com.wuxy.controller;

import com.wuxy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: wuxy
 * @create: 2019-04-10 15:36
 **/
@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/index")
    public String index(Model model, HttpSession session) {
//        List<User> list = new ArrayList<>();
//        model.addAttribute("list", list);
//        model.addAttribute("username", "mic");
//        model.addAttribute("flag", true);
//        model.addAttribute("age", 18);
//        model.addAttribute("sex", "男");
//        session.setAttribute("username","tom");
//        session.setAttribute("users",new ArrayList<>());
//        model.addAttribute("date", new Date());
//        model.addAttribute("img", "https://www.baidu.com/img/xinshouye_46cc6be3783724af1729ba51cfcde494.png");
        return "index";
    }

    @GetMapping("/validate")
    public String validate(Model model) {
        model.addAttribute("user", new User());
        return "test";
    }

    @PostMapping("/validate")
    public void validateUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() +"-"+ error.getDefaultMessage());
            }
        }
    }

}