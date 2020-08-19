package com.bc.crawler.server.service.impl;

import com.bc.crawler.server.entity.CrawlerShell;
import com.bc.crawler.server.mapper.CrawlerShellMapper;
import com.bc.crawler.server.service.CrawlerShellService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    /**
     * 保存爬虫脚本
     *
     * @param crawlerShell 爬虫脚本
     */
    @Override
    public void addCrawlerShell(CrawlerShell crawlerShell) {
        crawlerShellMapper.addCrawlerShell(crawlerShell);
    }

    /**
     * 修改爬虫脚本
     *
     * @param crawlerShell 爬虫脚本
     */
    @Override
    public void updateCrawlerShell(CrawlerShell crawlerShell) {
        crawlerShellMapper.updateCrawlerShell(crawlerShell);
    }

    /**
     * 删除爬虫脚本
     *
     * @param shellId 脚本ID
     */
    @Override
    public void deleteCrawlerShell(String shellId) {
        crawlerShellMapper.deleteCrawlerShell(shellId);
    }

    /**
     * 获取爬虫脚本分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 获取爬虫脚本列表
     */
    @Override
    public PageInfo<CrawlerShell> getCrawlerShellPageInfo(int pageNum, int pageSize, Map<String, String> paramMap) {
        PageHelper.startPage(pageNum, pageSize);
        List<CrawlerShell> crawlerShellList = crawlerShellMapper.getCrawlerShellList(paramMap);
        return new PageInfo<>(crawlerShellList);
    }
}
