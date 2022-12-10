package cn.tedu.spring.controller;


import cn.tedu.spring.entity.User;
import cn.tedu.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @PostMapping("/{1}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
        logger.debug("添加完成");
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id){
        logger.debug("获取用户 {}", id);
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody User user){
        userService.update(user);
    }

    @GetMapping
    public List<User> list(){
        List<User> list = userService.list();
        return list ;
    }

}
