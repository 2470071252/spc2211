package cn.tedu.spring.dao.Impl;


import cn.tedu.spring.dao.UserDao;
import cn.tedu.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class UserDaoJdbcImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addUser(User user) {
        String sql = "insert into user (id,username,password,roles) values (null,?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRoles());
            return ps;
        };
        int num = jdbcTemplate.update(preparedStatementCreator, keyHolder);
        user.setId(keyHolder.getKey().intValue());
        return num;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set username=?, password=?, roles=? where id=?";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getRoles(), user.getId());
    }

    @Override
    public int deleteUser(Integer id) {
        String sql = "delete from user where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<User> findAllUser() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, rowMapper);
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

    private RowMapper<User> rowMapper = (rs, index)->{
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRoles(rs.getString("roles"));
        return user;
    };

    @Override
    public User findUserByName(String username) {
        String sql = "select * from user where username=?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, username);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
