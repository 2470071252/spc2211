package cn.tedu.spring.dao.Impl;



import cn.tedu.spring.dao.AwardLogDao;
import cn.tedu.spring.entity.AwardLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Repository
public class AwardLogDaoJdbcImpl implements AwardLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveAwardLog(AwardLog awardLog) {
        String sql = "insert into award_log (award_id, point, description, grant_date) values (?,?,?,?)";
        return jdbcTemplate.update(sql, awardLog.getAwardId(), awardLog.getPoint(),
                awardLog.getDescription(), awardLog.getGrantDate());
    }

    @Override
    public int deleteAwardLog(Integer id) {
        String sql = "delete from award_log where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateAwardLog(AwardLog awardLog) {
        String sql = "update award_log set point=?, description=?, grant_date=? where award_id=?";
        return jdbcTemplate.update(sql, awardLog.getPoint(),
                awardLog.getDescription(), awardLog.getGrantDate(), awardLog.getAwardId());
    }

    RowMapper<AwardLog> rowMapper = (rs, rowNum) -> {
        AwardLog awardLog = new AwardLog();
        awardLog.setAwardId(rs.getInt("id"));
        awardLog.setPoint(rs.getInt("point"));
        awardLog.setDescription(rs.getString("description"));
        Date date = rs.getDate("grantDate");
        LocalDateTime grantDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        awardLog.setGrantDate(grantDate);
        return awardLog;
    };

    @Override
    public AwardLog findById(Integer id) {
        String sql = "select * from award_log where id=?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, id);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AwardLog> findAll() {
        String sql = "select * from award_log";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<AwardLog> findAllByAwardId(Integer awardId) {
        String sql = "select * from award_log where award_id=?";
        return jdbcTemplate.query(sql, rowMapper, awardId);
    }
}
