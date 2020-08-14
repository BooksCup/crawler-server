package com.bc.crawler.server.controller;

import com.bc.crawler.server.entity.CrawlerShell;
import com.bc.crawler.server.enums.ResponseMsg;
import com.bc.crawler.server.service.CrawlerShellService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 爬虫脚本
 *
 * @author zhou
 */
@RestController
@RequestMapping("/crawlerShell")
public class CrawlerShellController {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerShellController.class);

    @Resource
    CrawlerShellService crawlerShellService;

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
