package com.bc.crawler.server.mapper;

import com.bc.crawler.server.entity.CrawlerShell;
import com.bc.crawler.server.entity.ShellExecuteLog;

import java.util.List;
import java.util.Map;

/**
 * 爬虫脚本
 *
 * @author zhou
 */
public interface CrawlerShellMapper {

    /**
     * 根据业务类型获取爬虫脚本
     *
     * @param serviceType 业务类型
     * @return 爬虫脚本
     */
    CrawlerShell getCrawlerShellByServiceType(String serviceType);

    /**
     * 保存爬虫脚本
     *
     * @param crawlerShell 爬虫脚本
     */
    void addCrawlerShell(CrawlerShell crawlerShell);

    /**
     * 修改爬虫脚本
     *
     * @param crawlerShell 爬虫脚本
     */
    void updateCrawlerShell(CrawlerShell crawlerShell);

    /**
     * 删除爬虫脚本
     *
     * @param shellId 脚本ID
     */
    void deleteCrawlerShell(String shellId);

    /**
     * 获取爬虫脚本列表
     *
     * @param paramMap 参数map
     * @return 获取爬虫脚本列表
     */
    List<CrawlerShell> getCrawlerShellList(Map<String, String> paramMap);

    /**
     * 新增shell执行日志
     *
     * @param shellExecuteLog shell执行日志
     */
    void addShellExecuteLog(ShellExecuteLog shellExecuteLog);
}
