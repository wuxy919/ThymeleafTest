package com.wuxy.repository;

import com.wuxy.entity.Clazz;

import java.util.List;

/**
 * @author: wuxy
 * @create: 2019-04-16 12:13
 **/
public interface ClazzRepository {
    public List<Clazz> findAll();
    public Clazz findById(long id);
    public void save(Clazz clazz);
    public void update(Clazz clazz);
    public void deleteById(long id);
}
