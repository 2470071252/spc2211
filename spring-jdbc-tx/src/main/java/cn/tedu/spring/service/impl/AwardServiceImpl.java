package cn.tedu.spring.service.impl;


import cn.tedu.spring.dao.AwardDao;
import cn.tedu.spring.dao.AwardLogDao;
import cn.tedu.spring.entity.Award;
import cn.tedu.spring.entity.AwardLog;
import cn.tedu.spring.entity.User;
import cn.tedu.spring.exception.NotEnoughPointsException;
import cn.tedu.spring.service.AwardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public class AwardServiceImpl implements AwardService {
    private static Logger logger = LoggerFactory.getLogger(AwardServiceImpl.class);

    @Autowired
    private AwardLogDao awardLogDao;

    @Autowired
    private AwardDao awardDao;

    /**
     * REQUIRED 必须的
     * 事务传播属性，默认是  Propagation.REQUIRED
     * 如果当前没有事务，则开始新事务
     * 如果当前有事务，就参与到当前事务
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void grantAward(User user, String description, Integer point) {
        Award award = awardDao.findAwardByUserId(user.getId());
        if (award == null){
            award = new Award(null, user.getId(), 0);
            int num = awardDao.saveAward(award);
            if (num != 1){
                throw new RuntimeException("添加award记录失败！");
            }
        }
        logger.debug("生产id{}", award);
        addAwardLog(award.getUserId(), description, point);
        award.setPoint(award.getPoint()+point);
        int num = awardDao.updateAward(award);
        logger.debug("updateAward num:{}", num);
        if (num != 1){
            throw new RuntimeException("更新award记录失败！");
        }
//        if (num == 1){
//            throw new RuntimeException("呵呵");
//        }
    }

    @Override
    @Transactional
    public int deductPoints(User user, String description, Integer point) {
        Award award = awardDao.findAwardByUserId(user.getId());
        if (award == null){
            throw new NotEnoughPointsException("没有奖励点数");
        }
        if (award.getPoint() < point){
            throw new NotEnoughPointsException("奖励点数不足");
        }
        award.setPoint(award.getPoint() - point);
        awardDao.updateAward(award);
        AwardLog log = new AwardLog();
        log.setGrantDate(LocalDateTime.now());
        log.setPoint(point);
        log.setDescription(description);
        log.setAwardId(award.getId());
        awardLogDao.saveAwardLog(log);
        return point;
    }

    @Override
    public Award getAward(Integer id) {
        return awardDao.findAwardById(id);
    }

    @Override
    public Award getAward(User user) {
        return awardDao.findAwardByUserId(user.getId());
    }

    @Override
    public List<AwardLog> getLogs(User user) {
        Award award = getAward(user);
        return awardLogDao.findAllByAwardId(award.getId());
    }

    @Transactional
    public void addAwardLog(Integer awardId,  String description, Integer point){
        AwardLog awardLog = new AwardLog(
                null, awardId,point,description, LocalDateTime.now());
        int num = awardLogDao.saveAwardLog(awardLog);
        if (num != 1){
            throw new RuntimeException("添加award log记录失败！");
        }
    }



}
