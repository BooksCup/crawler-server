package com.bc.crawler.server.service;

import com.bc.crawler.server.entity.CrawlerShell;
import com.bc.crawler.server.entity.ShellExecuteLog;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * 爬虫脚本
 *
 * @author zhou
 */
public interface CrawlerShellService {

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
     * 获取爬虫脚本分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 获取爬虫脚本列表
     */
    PageInfo<CrawlerShell> getCrawlerShellPageInfo(int pageNum, int pageSize, Map<String, String> paramMap);

    /**
     * 新增shell执行日志
     *
     * @param shellExecuteLog shell执行日志
     */
    void addShellExecuteLog(ShellExecuteLog shellExecuteLog);

    /**
     * 执行爬虫脚本
     *
     * @param serviceType 脚本业务类型
     * @param executeType 脚本执行类型 "0": 手动执行 "1": 定时任务
     * @param path        脚本路径
     */
    void executeCrawlerShell(String serviceType, String executeType, String path);

    /**
     * 获取shell脚本执行日志分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return shell脚本执行日志分页信息
     */
    PageInfo<ShellExecuteLog> getShellExecuteLogPageInfo(int pageNum, int pageSize, Map<String, String> paramMap);
}
