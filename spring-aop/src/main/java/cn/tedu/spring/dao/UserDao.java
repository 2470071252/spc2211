package cn.tedu.spring.dao;


import cn.tedu.spring.entity.User;

import java.util.List;

public interface UserDao {

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

    List<User> findAllUser();

    User findUserById(Integer id);

    User findUserByName(String username);
}
