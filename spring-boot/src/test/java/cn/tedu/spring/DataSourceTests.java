package cn.tedu.spring;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
public class DataSourceTests {
    Logger logger = LoggerFactory.getLogger(DataSourceTests.class);

    @Test
    void test(){
        logger.debug("测试");
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void testJdbcTemplate(){
        logger.debug("{}", jdbcTemplate);
    }

    @Autowired
    DataSource dataSource;
    @Test
    void driver() throws SQLException {
        logger.debug("{}", dataSource.getConnection()
                        .getMetaData().getDriverName());
    }

    @Test
    void testDataSource(){
        logger.debug("{}", dataSource.getClass().getName());
    }
}
