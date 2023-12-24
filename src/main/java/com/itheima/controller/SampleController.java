package com.itheima.controller;

import com.itheima.domain.Sample;
import com.itheima.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    SampleService sampleService;
    @ResponseBody
    @RequestMapping("/insert")
    public Sample insert(Sample sample){
        sampleService.insert(sample);
        return sample;
    }

    @RequestMapping("/deleteById")
    public String deleteById(int id){
        sampleService.deleteById(id);
        return "/index.jsp";
    }
    @RequestMapping("/updateNameById")
    public String updateNameById(int id,String name){
        sampleService.updateNameById(id,name);
        return "/index.jsp";
    }


    @RequestMapping("/findByIds")
    @ResponseBody
    public List<Sample> findByIds(Integer[] ids){
        return sampleService.findByIds(ids);
    }
}
