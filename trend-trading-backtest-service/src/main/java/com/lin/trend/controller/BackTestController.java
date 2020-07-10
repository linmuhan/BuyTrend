package com.lin.trend.controller;

import com.lin.trend.pojo.IndexData;
import com.lin.trend.service.BackTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
  
@RestController
public class BackTestController {
    @Autowired BackTestService backTestService;
 
    @GetMapping("/simulate/{code}")
    @CrossOrigin
    public Map<String,Object> backTest(@PathVariable("code") String code) throws Exception {
        List<IndexData> allIndexDatas = backTestService.listIndexData(code);
        Map<String,Object> result = new HashMap<>();
        result.put("indexDatas", allIndexDatas);
        return result;
    }
}