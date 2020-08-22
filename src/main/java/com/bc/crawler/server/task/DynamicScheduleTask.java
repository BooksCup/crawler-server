package com.bc.crawler.server.task;

import com.bc.crawler.server.cons.Constant;
import com.bc.crawler.server.entity.CrawlerShell;
import com.bc.crawler.server.entity.Cron;
import com.bc.crawler.server.service.CrawlerShellService;
import com.bc.crawler.server.service.CronService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


/**
 * 动态配置定时任务
 *
 * @author zhou
 */
@Configuration
@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(DynamicScheduleTask.class);

    @Resource
    private CronService cronService;

    @Resource
    private CrawlerShellService crawlerShellService;


    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        List<Cron> cronList = cronService.getCronList();
        for (Cron cron : cronList) {

            Runnable task = () -> {
                logger.info(cron.getName() + " : " + LocalDateTime.now().toLocalTime());
                CrawlerShell crawlerShell = crawlerShellService.getCrawlerShellByServiceType(cron.getServiceType());
                if (null != crawlerShell) {
                    crawlerShellService.executeCrawlerShell(cron.getServiceType(), Constant.SHELL_EXECUTE_TYPE_CRON, crawlerShell.getPath());
                }
            };

            Trigger trigger = triggerContext -> {
                // 实时获取定时任务

                Cron realTimeCron = cronService.getCronById(cron.getId());

                CronTrigger cronTrigger = new CronTrigger(realTimeCron.getRule());
                return cronTrigger.nextExecutionTime(triggerContext);
            };

            scheduledTaskRegistrar.addTriggerTask(task, trigger);
        }


    }
}
