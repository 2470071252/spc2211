package cn.tedu.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DemoMapper {

    @Select("select 'Hello World!'")
    String hello();
}
