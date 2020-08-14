package com.bc.crawler.server.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;


/**
 * 动态配置定时任务
 *
 * @author zhou
 */
@Configuration
@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                // 添加任务内容(Runnable)
                () -> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
                // 设置执行周期(Trigger)
                triggerContext -> {
                    // 从数据库获取执行周期
//                    String cron = cronMapper.getCron();
                    // 合法性校验.
//                    if (StringUtils.isEmpty(cron)) {
//                        // Omitted Code ..
//                    }
                    // 返回执行周期(Date)
                    String cron = "0/10 * * * * ?";
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
