package cn.tedu.spring.service;


import cn.tedu.spring.entity.User;

import java.util.List;

/**
 * @Transactional 写在接口上， 全部的实现类的全部方法， 都参与事务
 */
//@Transactional
public interface UserService {

    User regist(String username, String pwd);

    User regist2(String username, String pwd);

    User login(String username, String pwd);

    List<User> list();

    User getById(Integer id);

    User getByUsername(String username);

    void update(User user);

    User delete(Integer id);

    void addUser(User user);
}
