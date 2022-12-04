package cn.tedu.spring.controller;


import cn.tedu.spring.entity.User;
import cn.tedu.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @PostMapping("/regist")
    public String regist(String username,String pwd){
        userService.regist(username,pwd);
        return "注册成功！";
    }

    @GetMapping("/login")
    public String login(String username, String pwd){
        logger.debug("登录凭证：{} {}", username, pwd);
        User user = userService.login(username,pwd);
        return "登录成功！";
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id){
        logger.debug("获取用户 {}", id);
        return userService.getById(id);
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }

    @GetMapping
    public List<User> list(Principal principal){
        //System.out.println("当前用户:"+principal.getName());
        List<User> list = userService.list();
        return list ;
    }

}
