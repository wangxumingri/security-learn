package com.wxss.service;

import com.wxss.pojo.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);

    User findUserByName(String name);

    User findUserByAccount(String account);

    List<User> findAll();

    List<User> findAllByPage(int page,int size);

    void addUser(User user);

    void deleteById(Long id);
}
