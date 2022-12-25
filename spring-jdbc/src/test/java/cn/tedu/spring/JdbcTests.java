package cn.tedu.spring;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


@SpringBootTest
public class JdbcTests {

    Logger logger = LoggerFactory.getLogger(JdbcTests.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void test() throws Exception{
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
            boolean b =  statement.execute(sql);
            logger.debug("创建了数据库, 是否有结果集{}", b);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
