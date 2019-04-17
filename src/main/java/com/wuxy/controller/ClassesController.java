package com.wuxy.controller;

import com.wuxy.entity.Clazz;
import com.wuxy.repository.ClazzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: wuxy
 * @create: 2019-04-16 20:06
 **/
@Controller
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClazzRepository clazzRepository;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list", clazzRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("classes", clazzRepository.findById(id));
        return modelAndView;
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        clazzRepository.deleteById(id);
        return "redirect:/classes/findAll";
    }

    @PostMapping("/update")
    public String update(Clazz clazz) {
        clazzRepository.update(clazz);
        return "redirect:/classes/findAll";
    }

    @PostMapping("/save")
    public String save(Clazz clazz) {
        clazzRepository.save(clazz);
        return "redirect:/classes/findAll";
    }

    @GetMapping("/redirect/{view}")
    public String redirect(@PathVariable("view") String view) {
        return view;
    }

}
