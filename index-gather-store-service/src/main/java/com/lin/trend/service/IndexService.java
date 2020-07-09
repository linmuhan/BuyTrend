package com.lin.trend.service;

import com.lin.trend.pojo.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
@Service
public class IndexService {
    private List<Index> indexes;
    @Autowired RestTemplate restTemplate;
 
    public List<Index> fetch_indexes_from_third_part(){
        List<Map> temp= restTemplate.getForObject("http://127.0.0.1:8090/indexes/codes.json",List.class);
        return map2Index(temp);
    }


    //通过http通信获得到的数据是map类型的，所以我们要将数据转换成我们需要的list类型即可
    private List<Index> map2Index(List<Map> temp) {
        List<Index> indexes = new ArrayList<>();
        for (Map map : temp) {
            String code = map.get("code").toString();
            String name = map.get("name").toString();
            Index index= new Index();
            index.setCode(code);
            index.setName(name);
            indexes.add(index);
        }
 
        return indexes;
    }
 
}