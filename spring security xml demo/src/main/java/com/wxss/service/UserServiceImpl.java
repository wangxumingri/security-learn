package com.wxss.service;

import com.wxss.pojo.User;
import com.wxss.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRespository userRespository;

    @Override
    public User findUserById(Long id) {
        Optional<User> optionalUser = userRespository.findById(id);
        return optionalUser.get();
    }

    @Override
    public User findUserByName(String name) {
        return userRespository.findByRealName(name);
    }

    @Override
    public User findUserByAccount(String account) {
        return userRespository.findByAccount(account);
    }

    @Override
    public List<User> findAll() {
        return userRespository.findAll();
    }

    @Override
    public List<User> findAllByPage(int page, int size) {

        Pageable pageable = PageRequest.of(page,size);
        Page<User> userPage = userRespository.findAll(pageable);
        List<User> content = userPage.getContent();
        return content;
    }

    @Override
    public void addUser(User user) {
        userRespository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRespository.deleteById(id);
    }
}
