package com.bc.crawler.server.service.impl;

import com.bc.crawler.server.cons.Constant;
import com.bc.crawler.server.entity.CrawlerShell;
import com.bc.crawler.server.entity.ShellExecuteLog;
import com.bc.crawler.server.mapper.CrawlerShellMapper;
import com.bc.crawler.server.service.CrawlerShellService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
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

    /**
     * 新增shell执行日志
     *
     * @param shellExecuteLog shell执行日志
     */
    @Override
    public void addShellExecuteLog(ShellExecuteLog shellExecuteLog) {
        crawlerShellMapper.addShellExecuteLog(shellExecuteLog);
    }

    /**
     * 执行爬虫脚本
     *
     * @param serviceType 脚本业务类型
     * @param executeType 脚本执行类型 "0": 手动执行 "1": 定时任务
     * @param path        脚本路径
     */
    @Override
    public void executeCrawlerShell(String serviceType, String executeType, String path) {
        try {
            Process process = Runtime.getRuntime().exec(path);
            StringBuffer resultBuffer = new StringBuffer();
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
            LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
            String line;
            process.waitFor();
            while ((line = lineNumberReader.readLine()) != null) {
                resultBuffer.append(line).append("\n");
            }
            ShellExecuteLog shellExecuteLog = new ShellExecuteLog(executeType,
                    serviceType, resultBuffer.toString());
            shellExecuteLog.setExecuteStatus(Constant.SHELL_EXECUTE_STATUS_SUCCESS);
            crawlerShellMapper.addShellExecuteLog(shellExecuteLog);
        } catch (Exception e) {
            e.printStackTrace();
            ShellExecuteLog shellExecuteLog = new ShellExecuteLog(executeType,
                    serviceType, e.getMessage());
            shellExecuteLog.setExecuteStatus(Constant.SHELL_EXECUTE_STATUS_FAIL);
            crawlerShellMapper.addShellExecuteLog(shellExecuteLog);
        }
    }

    /**
     * 获取shell脚本执行日志分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return shell脚本执行日志分页信息
     */
    @Override
    public PageInfo<ShellExecuteLog> getShellExecuteLogPageInfo(int pageNum, int pageSize, Map<String, String> paramMap) {
        PageHelper.startPage(pageNum, pageSize);
        List<ShellExecuteLog> shellExecuteLogList = crawlerShellMapper.getShellExecuteLogList(paramMap);
        return new PageInfo<>(shellExecuteLogList);
    }
}
