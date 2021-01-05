package com.bc.crawler.server.task;

import com.bc.crawler.server.entity.HotExchange;
import com.bc.crawler.server.service.HotExchangeService;
import com.bc.crawler.server.utils.CommonUtil;
import com.bc.crawler.server.utils.HttpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 新浪汇率爬取任务
 *
 * @author zhou
 */
@Configuration
@EnableScheduling
public class SinaExchangeRateTask {

    @Resource
    private HotExchangeService hotExchangeService;

    @Scheduled(cron = "0/50 * * * * ?")
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        getSinaExchageRate();
    }

    private void getSinaExchageRate() {
        String url = "https://hq.sinajs.cn/rn=" + System.currentTimeMillis() + "list=fx_susdcny";
        String result = HttpUtil.doGet(url);
        System.out.println(result);
        result = result.replaceAll("var hq_str_fx_susdcny=\"", "");
        result = result.replaceAll("\";", "");
        result = result.replaceAll("\n", "");
        String[] datas = result.split(",");
        HotExchange hotExchange = new HotExchange();
        hotExchange.setId(CommonUtil.generateId());
        hotExchange.setCurrencyName("美元");
        String currentPrice = datas[2];
        hotExchange.setCurrentPrice(currentPrice);
        String yesterdayPrice = datas[3];
        hotExchange.setYesterdayPrice(yesterdayPrice);
        String todayPrice = datas[5];
        hotExchange.setTodayPrice(todayPrice);
        String highestPrice = datas[6];
        String lowestPrice = datas[7];
        hotExchange.setHighestPrice(highestPrice);
        hotExchange.setLowestPrice(lowestPrice);

        String createTime = datas[17] + " " + datas[0];
        hotExchange.setCreateTime(createTime);

        String change1 = datas[11];
        String change2 = datas[10];
        hotExchange.setChange1(change1);
        hotExchange.setChange2(change2);

        String change = datas[11] + "(" + datas[10] + "%)";
        hotExchange.setChange(change);

        hotExchangeService.addHotExchange(hotExchange);
    }
}
