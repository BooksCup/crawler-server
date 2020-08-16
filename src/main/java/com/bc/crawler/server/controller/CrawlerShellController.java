package com.bc.crawler.server.controller;

import com.bc.crawler.server.cons.Constant;
import com.bc.crawler.server.entity.CrawlerShell;
import com.bc.crawler.server.enums.ResponseMsg;
import com.bc.crawler.server.service.CrawlerShellService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 爬虫脚本
 *
 * @author zhou
 */
@CrossOrigin
@RestController
@RequestMapping("/crawlerShell")
public class CrawlerShellController {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerShellController.class);

    @Resource
    CrawlerShellService crawlerShellService;

    /**
     * 获取爬虫脚本分页信息
     *
     * @param page  当前分页数
     * @param limit 分页大小
     * @return 爬虫脚本分页信息
     */
    @ApiOperation(value = "获取爬虫脚本分页信息", notes = "获取爬虫脚本分页信息")
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<CrawlerShell>> getCrawlerShellPageInfo(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        logger.info("[getCrawlerShellPageInfo], page: " + page + ", limit: " + limit);
        ResponseEntity<PageInfo<CrawlerShell>> responseEntity;
        try {
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            PageInfo<CrawlerShell> weavePricePageInfo = crawlerShellService.getCrawlerShellPageInfo(page, limit, paramMap);
            responseEntity = new ResponseEntity<>(weavePricePageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 执行爬虫脚本
     *
     * @return ResponseEntity<String>
     */
    @ApiOperation(value = "执行爬虫脚本", notes = "执行爬虫脚本")
    @PostMapping(value = "/execute")
    public ResponseEntity<String> executeCrawlerShell(
            @RequestParam String serviceType) {
        logger.info("[executeCrawlerShell], serviceType: " + serviceType);
        ResponseEntity<String> responseEntity;
        try {
            CrawlerShell crawlerShell = crawlerShellService.getCrawlerShellByServiceType(serviceType);
            if (null != crawlerShell) {
                logger.info("[executeCrawlerShell], path: " + crawlerShell.getPath());
                Process ps = Runtime.getRuntime().exec(crawlerShell.getPath());
                ps.waitFor();
            }
            responseEntity = new ResponseEntity<>(ResponseMsg.EXECUTE_CRAWLER_SUCCESS.getResponseCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[executeCrawlerShell] error, msg: " + e.getMessage());
            responseEntity = new ResponseEntity<>(ResponseMsg.EXECUTE_CRAWLER_ERROR.getResponseCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
