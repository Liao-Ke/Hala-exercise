package com.itheima.dao;

import com.itheima.domain.Sample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SampleMapper {
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into tb_sample (name) values (#{name})")
    void insert(Sample sample);

    @Delete("delete from tb_sample where id=#{id}")
    void deleteById(int id);

    @Update("update tb_sample set name=#{name} where id=#{id}")
    void updateNameById(@Param("id") int id,@Param("name") String name);

    List<Sample> findByIds(Integer[] ids);
}
