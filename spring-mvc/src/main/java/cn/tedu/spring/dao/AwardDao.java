package cn.tedu.spring.dao;


import cn.tedu.spring.entity.Award;

public interface AwardDao {

    Integer saveAward(Award award);

    Integer updateAward(Award award);

    Integer deleteById(Integer id);

    Award findAwardById(Integer id);

    Award findAwardByUserId(Integer userId);

}
