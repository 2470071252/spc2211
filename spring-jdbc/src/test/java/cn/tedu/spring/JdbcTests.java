package cn.tedu.spring;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;


@SpringBootTest
public class JdbcTests {

    Logger logger = LoggerFactory.getLogger(JdbcTests.class);

    @Autowired
    DataSource dataSource;

    /**
     * Spring Boot starter jdbc 自动配置时候, 如果发现了 DataSource 被配置了
     * 就会自动创建 jdbcTemplate
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void test() throws Exception{
        //Spring Boot 会根据数据库配置,自动切换数据库连接
        logger.debug("dataSource {}", dataSource.getClass().getName());
        logger.debug("jdbcTemplate {}", jdbcTemplate.getClass().getName());
        logger.debug("driver {}", dataSource.getConnection().getClass().getName());
        logger.debug("Database {}", dataSource.getConnection().getMetaData());
    }

    @Test
    void createTable(){
        String sql = "create table product (id int, name varchar(50))";
        try(Connection conn = dataSource.getConnection()){
            Statement statement = conn.createStatement();
            boolean b = statement.execute(sql);
            //true if the first result is a ResultSet object;
            //false if it is an update count or there are no results
            logger.debug("创建了数据库, 是否有结果集{}", b);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Test
    void insertData(){
        String sql = "insert into product (id, name) values (?,?)";
        try(Connection conn = dataSource.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "手机");
            int n = preparedStatement.executeUpdate();
            logger.debug("插入数据 {}", n);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    void selectData(){
        String sql = "select * from product";
        try(Connection conn = dataSource.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                logger.debug("{} {}", rs.getInt("id"),
                        rs.getString("name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
