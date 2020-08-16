package com.bc.crawler.server.mapper;

import com.bc.crawler.server.entity.CrawlerShell;

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
     * 获取爬虫脚本列表
     *
     * @param paramMap 参数map
     * @return 获取爬虫脚本列表
     */
    List<CrawlerShell> getCrawlerShellList(Map<String, String> paramMap);
}
