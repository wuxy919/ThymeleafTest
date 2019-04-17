package com.wuxy.controller;

import com.wuxy.entity.Clazz;
import com.wuxy.entity.User;
import com.wuxy.repository.ClazzRepository;
import com.wuxy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author: wuxy
 * @create: 2019-04-16 12:18
 **/
@RestController
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    private ClazzRepository clazzRepository;

    @GetMapping("/findAll")
    public List<Clazz> findAll() {
        return clazzRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Clazz findById(@PathVariable("id") long id) {
        return clazzRepository.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Clazz clazz) {
        clazzRepository.save(clazz);
    }

    @PutMapping("/update")
    public void update(@RequestBody Clazz clazz) {
        clazzRepository.update(clazz);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        clazzRepository.deleteById(id);
    }


}
