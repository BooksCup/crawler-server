package com.bc.crawler.server.service;

import com.bc.crawler.server.entity.CrawlerShell;

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
}
