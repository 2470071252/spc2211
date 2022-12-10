package cn.tedu.spring.service;


import cn.tedu.spring.entity.Award;
import cn.tedu.spring.entity.AwardLog;
import cn.tedu.spring.entity.User;

import java.util.List;

public interface AwardService {
    /**
     * 奖励点数
     * @param user 用户
     * @param description 奖励原因
     * @param point 点数
     */
    void grantAward(User user, String description, Integer point);

    /**
     * 扣除点数
     * @param user 用户
     * @param description 扣除原因
     * @param point 点数
     * @return
     */
    int deductPoints(User user, String description, Integer point);
    Award getAward(Integer id);
    Award getAward(User user);
    List<AwardLog> getLogs(User user);
}
