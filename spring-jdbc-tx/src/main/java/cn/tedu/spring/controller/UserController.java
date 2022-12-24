package cn.tedu.spring.controller;


import cn.tedu.spring.entity.User;
import cn.tedu.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    // http://localhost:8080/users
    @PostMapping
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

    @GetMapping
    public List<User> list(){
        List<User> list = userService.list();
        return list ;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT) //NO_CONTENT 没有内容
    public void updateUser(@RequestBody User user){
        userService.update(user);
        logger.debug("更新完成！");
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        userService.delete(id);
        logger.debug("删除了");
    }



    @GetMapping("/export")
    public ResponseEntity export() throws Exception{
        //将用户信息导出为CSV数据
        List<User> users = userService.list();
        StringBuilder buf = new StringBuilder("编号,用户名,密码,角色\n");
        for (User user: users) {
            buf.append(user.getId()).append(",")
                    .append(user.getUsername()).append(",")
                    .append(user.getPassword()).append(",")
                    .append("\"").append(user.getRoles()).append("\"\n");
        }

        //生成响应Body数据
        byte[] body = buf.toString().getBytes("GBK");
        //文件名在 HTTP 头中传输，必须进行 编码处理
        String filename = URLEncoder.encode("用户名单.csv", "UTF-8");
        //创建自定义响应消息
        ResponseEntity responseEntity =
                ResponseEntity.ok()
                .contentLength(body.length)
                .header("Content-Type", "text/csv")
                .header("Content-Disposition",
                        "attachment; filename=\""+filename+"\"")
                .body(body);
        return responseEntity;
    }
}
