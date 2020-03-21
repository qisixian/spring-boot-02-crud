package com.sishiancode.springboot.dao;

import com.sishiancode.springboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDao {
    private static Map<Integer, User> users = null;

    @Autowired
    private static UserRepository repository;

    static {
        users = new HashMap<Integer, User>();

        users.put(1001, new User("1001", "aa@qq.com","13300001111","aaaa"));
        users.put(1002, new User("1002", "bb@qq.com","13300002222","bbbb"));
        users.put(1003, new User("1003", "cc@qq.com","13300003333","cccc"));
        users.put(1004, new User("1004", "dd@qq.com","13300004444","dddd"));
        users.put(1005, new User("1005", "ee@qq.com","13300005555","eeee"));
        users.put(1006, new User("1006", "ff@qq.com","13300006666","ffff"));

    }

    private static Integer initId = 1007;

//    public void save(User user){
//        if(user.getId() == null){
//            user.setId(initId++);
//        }
//
//        users.put(user.getId(), user);
//    }


    //查询所有用户
    public Collection<User> getAll(){
        return users.values();
    }


    public User get(Integer id){
        return users.get(id);
    }


    public void delete(Integer id){
        users.remove(id);
    }



}
