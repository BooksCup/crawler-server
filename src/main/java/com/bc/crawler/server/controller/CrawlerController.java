package com.bc.crawler.server.controller;

import com.bc.crawler.server.cons.Constant;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 爬虫
 *
 * @author zhou
 */
@RestController
@RequestMapping("/crawler")
public class CrawlerController {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerController.class);

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
            if (Constant.SERVICE_TYPE_WEAVE_PRICE.equals(serviceType)) {
                String path = "/home/scrapy/crawler/cron.sh";
                Process ps = Runtime.getRuntime().exec(path);
                ps.waitFor();
            }
            responseEntity = new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[executeCrawlerShell] error, msg: " + e.getMessage());
            responseEntity = new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
