package com.wuxy.repository;

import com.wuxy.entity.User;

import java.util.List;

/**
 * @author: wuxy
 * @create: 2019-04-16 12:13
 **/
public interface UserRepository {
    public List<User> findAll();
    public User findById(long id);
    public void save(User user);
    public void update(User user);
    public void deleteById(long id);
}
