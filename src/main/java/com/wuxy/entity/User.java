package com.wuxy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: wuxy
 * @create: 2019-04-10 16:44
 **/
@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
}
