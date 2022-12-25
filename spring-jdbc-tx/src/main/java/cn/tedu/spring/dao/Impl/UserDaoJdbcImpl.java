package cn.tedu.spring.dao.Impl;


import cn.tedu.spring.dao.UserDao;
import cn.tedu.spring.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;


@Repository //仓库
@ConditionalOnMissingBean(UserDaoPureJdbcImpl.class)
public class UserDaoJdbcImpl implements UserDao {

    Logger logger = LoggerFactory.getLogger(UserDaoJdbcImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int updateUser(User user) {
        String sql = "update user set username=?, password=?, roles=? where id=?";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),
                user.getRoles(), user.getId());
    }


//    @Override
//    public int addUser(User user) {
//        String sql = "insert into user (id,username,password,roles) values (null,?,?,?)";
//        int num = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getRoles());
//        return num;
//    }

    @Override
    public int addUser(User user) {

        String sql = "insert into user (id,username,password,roles) values (null,?,?,?)";
        //获取自动生成的 主键 值
        //用于抓取生产的ID的工具 keyHolder Generated生成 Key关键 Holder 抓住的人
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            //创建 PreparedStatement, 务必添加
            // Statement.RETURN_GENERATED_KEYS参数, 表示需要返回生成的ID
            PreparedStatement ps = con.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            //设置ps参数
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRoles());
            //返回 ps 对象
            return ps;
        };
        int num = jdbcTemplate.update(preparedStatementCreator, keyHolder);
        //SQL 语句执行完成以后, 从keyHolder中抓取生产的自增ID
        user.setId(keyHolder.getKey().intValue());
        return num;
    }


    @Override
    public Integer countUsers() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<Map<String, Object>> findAllUsers() {
        /*
         * queryForList方法，返回map封装的查询结果
         * - 使用方便，无需定义实体类， 写的爽！
         * - 缺点是返回值，都是通用类型，没有明确语义信息，不方便维护代码
         */
        String sql = "select * from user";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * Row 行 Mapper 映射
     * 将ResultSet中的一行映射为一个实体对象
     */
    private RowMapper<User> rowMapper = (rs, index)->{
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRoles(rs.getString("roles"));
        return user;
    };

    @Override
    public List<User> findAllUser() {
        /*
         * 使用 RowMapper 将查询结果映射为实体对象
         */
        String sql = "select * from user";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public User findUserByName(String username) {
        /*
         * 使用条件查询唯一的一个结果
         * queryForObject 方法查询结果为0，会出现异常 EmptyResultDataAccessException
         * 查询结果多于1行也会出现异常
         */
        String sql = "select * from user where username=?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, username);
        }catch (EmptyResultDataAccessException e){
            //用户名条件没有查询到结果， 就会出现异常
            logger.warn("空查询结果", e);
            return null;
        }
    }

    @Override
    public int deleteUser(Integer id) {
        String sql = "delete from user where id = ?";
        return jdbcTemplate.update(sql, id);
    }


    @Override
    public User findUserById(Integer id) {
        String sql = "select * from user where id=?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, id);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

}
