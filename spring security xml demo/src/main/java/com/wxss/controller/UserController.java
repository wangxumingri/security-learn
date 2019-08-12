package com.wxss.controller;

import com.wxss.pojo.User;
import com.wxss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/saveUser",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> saveUser(@RequestBody User user){
        // 日志
        System.out.println("新增用户:"+user.toString());

        Map<String,Object> result = new HashMap<>();
        try {
            userService.addUser(user);
            result.put("code",100);
            result.put("message","成功");
        } catch (Exception e) {
            // 日志打印错误信息
            System.err.println(e.getMessage());
            result.put("code",400);
            result.put("message","失败");
        }
        return result;
    }

}
