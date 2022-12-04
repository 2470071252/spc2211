package cn.tedu.spring.dao.Impl;



import cn.tedu.spring.dao.AwardDao;
import cn.tedu.spring.entity.Award;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class AwardDaoJdbcImpl implements AwardDao {

    Logger logger = LoggerFactory.getLogger(AwardDaoJdbcImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer saveAward(Award award) {
        String sql = "insert into award (user_id, point) values (?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement preparedStatement =
                    con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, award.getUserId());
            preparedStatement.setInt(2, award.getPoint());
            return preparedStatement;
        };
        int num = jdbcTemplate.update(preparedStatementCreator, keyHolder);
        award.setId(keyHolder.getKey().intValue());
        return num;
    }

    @Override
    public Integer updateAward(Award award) {
        String sql = "update award set user_id=?, point=? where id=?";
        return jdbcTemplate.update(sql, award.getUserId(), award.getPoint(), award.getId());
    }

    @Override
    public Integer deleteById(Integer id) {
        String sql = "delete from award where id=?";
        return jdbcTemplate.update(sql, id);
    }

    private RowMapper<Award> rowMapper = (rs, rowNum) -> {
        Award award = new Award();
        award.setId(rs.getInt("id"));
        award.setUserId(rs.getInt("user_id"));
        award.setPoint(rs.getInt("point"));
        return award;
    };

    @Override
    public Award findAwardById(Integer id) {
        String sql = "select id, user_id, point from award where id=?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public Award findAwardByUserId(Integer userId) {
        String sql = "select id, user_id, point from award where user_id=?";
        logger.debug("sql:{} parma: {}", sql, userId);
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, userId);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
