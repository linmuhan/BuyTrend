package com.lin.trend.web;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
 
import com.lin.trend.config.IpConfiguration;
import com.lin.trend.pojo.IndexData;
import com.lin.trend.service.IndexDataService;
  
@RestController
public class IndexDataController {
    @Autowired IndexDataService indexDataService;
    @Autowired IpConfiguration ipConfiguration;
     
//  http://127.0.0.1:8021/data/000300
 
    @GetMapping("/data/{code}")
    public List<IndexData> get(@PathVariable("code") String code) throws Exception {
        System.out.println("current instance is :" + ipConfiguration.getPort());
        return indexDataService.get(code);
    }
}