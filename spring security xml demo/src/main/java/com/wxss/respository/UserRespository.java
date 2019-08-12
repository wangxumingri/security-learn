package com.wxss.respository;

import com.wxss.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User,Long> {
    User findByRealName(String realName);
    User findByAccount(String account);
}
