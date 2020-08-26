package com.bc.crawler.server.controller;

import com.bc.crawler.server.cons.Constant;
import com.bc.crawler.server.entity.ExchangeRate;
import com.bc.crawler.server.entity.WeavePrice;
import com.bc.crawler.server.service.ExchangeRateService;
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
 * 汇率
 *
 * @author zhou
 */
@CrossOrigin(exposedHeaders = "responseCode")
@RestController
@RequestMapping("/exchangeRate")
public class ExchangeRateController {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeRateController.class);

    @Resource
    private ExchangeRateService exchangeRateService;

    /**
     * 获取汇率分页信息
     *
     * @param page  当前分页数
     * @param limit 分页大小
     * @return 汇率分页信息
     */
    @ApiOperation(value = "获取汇率分页信息", notes = "获取汇率分页信息")
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<ExchangeRate>> getExchangeRatePageInfo(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        logger.info("[getExchangeRatePageInfo], page: " + page + ", limit: " + limit);
        ResponseEntity<PageInfo<ExchangeRate>> responseEntity;
        try {
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            PageInfo<ExchangeRate> exchangeRatePageInfo = exchangeRateService.getExchangeRatePageInfo(page, limit, paramMap);
            responseEntity = new ResponseEntity<>(exchangeRatePageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
