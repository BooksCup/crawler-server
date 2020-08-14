package com.bc.crawler.server.service.impl;

import com.bc.crawler.server.entity.CrawlerShell;
import com.bc.crawler.server.mapper.CrawlerShellMapper;
import com.bc.crawler.server.service.CrawlerShellService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 爬虫脚本
 *
 * @author zhou
 */
@Service("crawlerShellService")
public class CrawlerShellServiceImpl implements CrawlerShellService {

    @Resource
    private CrawlerShellMapper crawlerShellMapper;

    /**
     * 根据业务类型获取爬虫脚本
     *
     * @param serviceType 业务类型
     * @return 爬虫脚本
     */
    @Override
    public CrawlerShell getCrawlerShellByServiceType(String serviceType) {
        return crawlerShellMapper.getCrawlerShellByServiceType(serviceType);
    }
}
