package com.lin.trend.job;

import java.util.List;
 
import cn.hutool.core.date.DateUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
 
import com.lin.trend.pojo.Index;
import com.lin.trend.service.IndexDataService;
import com.lin.trend.service.IndexService;

//同时刷新指数代码和数据
public class IndexDataSyncJob extends QuartzJobBean {
     
    @Autowired
    private IndexService indexService;
 
    @Autowired
    private IndexDataService indexDataService;
     
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("定时启动：" + DateUtil.now());
        List<Index> indexes = indexService.fresh();
        for (Index index : indexes) {
             indexDataService.fresh(index.getCode());
        }
        System.out.println("定时结束：" + DateUtil.now());
 
    }
 
}