package cn.tedu.spring.dao.Impl;

import cn.tedu.spring.dao.UserDao;
import cn.tedu.spring.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 传统 JDBC 数据库访问API
 */
// @Repository
public class UserDaoPureJdbcImpl implements UserDao {

    private Logger logger = LoggerFactory.getLogger(UserDaoPureJdbcImpl.class);

    @Autowired
    private DataSource dataSource;
    @Override
    public int updateUser(User user) {
        String sql = "UPDATE user SET username = ?, password = ?, roles = ? " +
                "WHERE id = ?";
        //1. 注册数据库驱动， MySQL数据库驱动会自动完成
        //2. 创建连接
        try (Connection connection = dataSource.getConnection()){
            //3. 创建 Statement对象
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRoles());
            ps.setInt(4, user.getId());
            //4. 执行SQL语句
            int n = ps.executeUpdate();
            //5 处理SQL结果
            return n;
        }catch (SQLException e){
            logger.error("插入失败",e);
            throw new RuntimeException(e);
        }
        //6 自动关闭连接
    }
    @Override
    public int addUser(User user) {
        String sql = "INSERT INTO user (id, username, password, roles) " +
                "VALUE (null, ?, ?, ?)";
        //1. 注册数据库驱动， 自动完成
        //2. 创建连接
        try (Connection connection = dataSource.getConnection()){
            //3. 创建 Statement对象
            PreparedStatement ps=connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRoles());
            //4. 执行SQL语句
            int n = ps.executeUpdate();
            //5 处理SQL结果
            //获取自动生成的ID
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                //为User 设置刚刚生成的ID
                user.setId(rs.getInt(1));
            }
            return n;
        }catch (SQLException e){
            logger.error("插入失败",e);
            throw new RuntimeException(e);
        }
        //6. 关闭数据库连接， 采用Java 7的自动关闭功能
    }



    @Override
    public Integer countUsers() {
        String sql = "select count(*) from user";
        try (Connection connection = dataSource.getConnection()){
            //3. 创建 Statement对象
            PreparedStatement ps=connection.prepareStatement(sql);
            //4. 执行SQL语句
            ResultSet resultSet = ps.executeQuery();
            //5 处理SQL结果
            if (resultSet.next()){
                return resultSet.getInt(1);
            }
            return 0;
        }catch (SQLException e){
            logger.error("插入失败",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteUser(Integer id) {
        String sql = "DELETE FROM student WHERE id = ?";
        try (Connection connection = dataSource.getConnection()){
            //3. 创建 Statement对象
            PreparedStatement ps=connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            //4. 执行SQL语句
            int n = ps.executeUpdate();
            //5 处理SQL结果
            return n;
        }catch (SQLException e){
            logger.error("插入失败",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAllUser() {
        String sql = "SELECT id, username, password, roles FROM users";
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> list = new ArrayList<>();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRoles(resultSet.getString("roles"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserById(Integer id) {
        String sql = "SELECT id, username, password, roles FROM users WHERE id=?";
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRoles(resultSet.getString("roles"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserByName(String username) {
        String sql = "SELECT id, username, password, roles FROM users WHERE username =?";
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRoles(resultSet.getString("roles"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Map<String, Object>> findAllUsers() {
        return null;
    }
}
