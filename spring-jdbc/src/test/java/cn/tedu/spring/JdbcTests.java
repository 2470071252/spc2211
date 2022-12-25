package cn.tedu.spring;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


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
}
