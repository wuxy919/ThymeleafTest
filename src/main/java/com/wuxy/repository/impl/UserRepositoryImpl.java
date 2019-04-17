package com.wuxy.repository.impl;

import com.wuxy.entity.User;
import com.wuxy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author: wuxy
 * @create: 2019-04-16 12:15
 **/
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
   private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from t_user", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(long id) {
//        return jdbcTemplate.query("select * from t_user where id = ?", new BeanPropertyRowMapper<>(User.class), id).get(0);
        return jdbcTemplate.queryForObject("select * from t_user where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void save(@RequestBody User user) {
        jdbcTemplate.update("insert into t_user(name, password, age) values (?,?,?)", user.getName(), user.getPassword(), user.getAge());
    }

    @Override
    public void update(@RequestBody User user) {
        jdbcTemplate.update("update t_user set name = ?, password = ?, age = ? where id = ?", user.getName(), user.getPassword(), user.getAge(), user.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("delete from t_user where id = ?", id);
    }
}
