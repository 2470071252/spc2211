package cn.tedu.spring.dao;



import cn.tedu.spring.entity.AwardLog;

import java.util.List;

public interface AwardLogDao {

    int saveAwardLog(AwardLog awardLog);

    int deleteAwardLog(Integer id);

    int updateAwardLog(AwardLog awardLog);

    AwardLog findById(Integer id);

    List<AwardLog> findAll();

    List<AwardLog> findAllByAwardId(Integer awardId);
}
