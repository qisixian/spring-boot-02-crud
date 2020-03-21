package com.sishiancode.springboot.controller;

import com.sishiancode.springboot.dao.UserDao;
import com.sishiancode.springboot.dao.UserRepository;
import com.sishiancode.springboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    String list(Model model){
        //Collection<User> users=userDao.getAll();
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "users/list";
    }

    @GetMapping("/user")
    String toAddPage(Model model){
        //Collection<User> users=userDao.getAll();
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "users/add";
    }

    @PostMapping("/user")
    String addUser(User user){
        System.out.println("添加的用户信息"+user);
        //userDao.save(user);
        userRepository.save(user);
        return "redirect:users";
    }

    @GetMapping("/user/{id}")
    String toEditPage(@PathVariable("id") String id, Model model){
        //User user = userDao.get(id).get();
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("targetUser", user.get());
        return "users/add";
    }

    @PutMapping("/user")
    String updateUser(User user){
        System.out.println("修改的的用户信息"+user);
        //userDao.save(user);
        userRepository.save(user);
        return "redirect:users";
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable("id") String id, Model model){
        //userDao.delete(id);
        userRepository.deleteById(id);
        System.out.println("delete方法生效"+id);
        //return "redirect:users";//使用form表单post put delete 之后的重定向会出问题（没参数的post和put都没问题啊）

        //Collection<User> users=userDao.getAll();
        List<User> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "users/list";//不用重定向就没问题了
    }

    @PostMapping("/user/{id}")
    String testUser(@PathVariable("id") String id){
        System.out.println("post方法生效"+id);

        return "redirect:users";
    }
}
