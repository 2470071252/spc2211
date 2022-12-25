package cn.tedu.spring.service.impl;


import cn.tedu.spring.dao.UserDao;
import cn.tedu.spring.entity.User;
import cn.tedu.spring.exception.*;
import cn.tedu.spring.service.AwardService;
import cn.tedu.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

/**
 * @Transactional 写在类上， 则当前类的全部方法都参与事务
 * 类上定义@Transactional属性，传播到每个方法上
 */
@Service
@Transactional(timeout = 30)
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    AwardService awardService;

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User regist2(String username, String pwd) {
        DataSource dataSource = jdbcTemplate.getDataSource();
        Connection con = null;
        try (Connection conn = DataSourceUtils.doGetConnection(dataSource)){
            con = conn;
            conn.setAutoCommit(false);
            User user = new User();
            user.setUsername(username);
            user.setPassword(pwd);
            user.setRoles("USER");
            userDao.addUser(user);
            awardService.grantAward(user, "注册", 200);
            conn.commit();
            conn.setAutoCommit(true);
            return user;
        }catch (Exception e){
            logger.error("失败", e);
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addUser(User user) {
        User findUser = userDao.findUserByName(user.getUsername());
        logger.debug("从数据库查到 {}", findUser);
        if (findUser!=null) {
            logger.warn("用户 {} 已经被注册！", user);
            throw new UsernameExistsException("该用户名已经被注册！");
        }
        logger.debug("开始注册过程");
        int i = userDao.addUser(user);
        logger.debug("注册更新数量 {}", i);
        if (i!=1) {
            logger.warn("注册用户失败！");
            throw new RegistrationFailedException("注册用户失败！");
        }
        logger.debug("注册成功！{}", user);
    }

    /**
     * 方法上  @Transactional(timeout = 40) 属性可以覆盖， 类上
     * 声明的事务属性
     * rollbackFor = {Exception.class} 用于指定，回滚的异常类型的父类型
     * 默认的是 RuntimeException 以及子类， 很少修改这个值
     * timeout = 40，事务抄送时间，如果方法执行超时，就提前结束，回退事务，单位是秒
     *
     */
    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 40,
    isolation = Isolation.READ_COMMITTED)
    public User regist(String username, String password) {
        if (username==null || password==null) {
            logger.warn("输入参数为空{}, {}", username, password);
            throw new IllegalParameterException("参数异常！");
        }
        logger.debug("输入参数{}, {}", username, password);
        User findUser = userDao.findUserByName(username);
        logger.debug("从数据库查到 {}", findUser);
        if (findUser!=null) {
            logger.warn("用户名 {} 已经被注册！", username);
            throw new UsernameExistsException("该用户名已经被注册！");
        }
        logger.debug("开始注册过程");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int i = userDao.addUser(user);
        logger.debug("注册更新数量 {}", i);
        if (i!=1) {
            logger.warn("注册用户失败！");
            throw new RegistrationFailedException("注册用户失败！");
        }
        logger.debug("注册成功！{}", user);
        //注册送积分
        awardService.grantAward(user, "注册", 100);
        //if (i==1){
        //    throw new RuntimeException("测试故障");
        //}
        return user;
    }

    @Override
    public User login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new IllegalParameterException("用户名密码不能为空！");
        }
        User user = userDao.findUserByName(username);

        if (user==null) {
            logger.warn("用户 {} 不存在！", username);
            throw new UserNotFoundException("该用户不存在！");
        }
        if (!user.getPassword().equals(password)) {
            logger.warn("密码错误！{} ", password);
            throw new PasswordErrorException("密码错误！");
        }
        //登录送积分
        awardService.grantAward(user, "登录", 50);
        return user;
    }

    @Override

    public List<User> list() {
        logger.debug("获取用户列表");
        return userDao.findAllUser();
    }

    @Override
    public User getById(Integer id) {
        logger.debug("获取用户信息{}", id);
        return userDao.findUserById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    //@Transactional
    public void update(User user) {
        User user1 = userDao.findUserById(user.getId());
        if (user1 == null){
            throw new UserNotFoundException("没有用户");
        }
        int n = userDao.updateUser(user);
        if (n != 1){
            throw new UpdateFailedException("更新失败！");
        }
    }

    @Override
    public User delete(Integer id) {
        User user = userDao.findUserById(id);
        if (user == null){
            throw new UserNotFoundException("没有用户id");
        }
        int n = userDao.deleteUser(id);
        if (n != 1){
            throw new DeleteFailedException("更新失败！");
        }
        return user;
    }
}
