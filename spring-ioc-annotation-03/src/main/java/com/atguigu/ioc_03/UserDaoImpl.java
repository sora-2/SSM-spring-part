package com.atguigu.ioc_03;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public String show() {
        return "show";
    }
}
