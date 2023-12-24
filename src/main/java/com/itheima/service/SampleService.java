package com.itheima.service;

import com.itheima.dao.SampleMapper;
import com.itheima.domain.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {
    @Autowired
    SampleMapper sampleMapper;
    public void insert(Sample sample){
        sampleMapper.insert(sample);
    }

    public void deleteById(int id){
        sampleMapper.deleteById(id);
    }

    public void updateNameById(int id,String name){
        sampleMapper.updateNameById(id,name);
    }

    public List<Sample> findByIds(Integer[] ids){
        return sampleMapper.findByIds(ids);
    }
}
