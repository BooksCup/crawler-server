package com.bc.crawler.server.controller;

import com.bc.crawler.server.cons.Constant;
import com.bc.crawler.server.entity.ExchangeRate;
import com.bc.crawler.server.service.ExchangeRateService;
import com.bc.crawler.server.utils.TimeUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

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
     * 获取币种列表
     *
     * @return 币种列表
     */
    @ApiOperation(value = "获取币种列表", notes = "获取币种列表")
    @GetMapping(value = "/currency")
    public ResponseEntity<List<String>> getCurrencyList() {
        logger.info("[getCurrencyList]");
        ResponseEntity<List<String>> responseEntity;
        try {
            List<String> currencyList = exchangeRateService.getCurrencyList();
            responseEntity = new ResponseEntity<>(currencyList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

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
            @RequestParam(required = false) String currencyName,
            @RequestParam(required = false) String date,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        logger.info("[getExchangeRatePageInfo], page: " + page + ", limit: " + limit
                + ", currencyName: " + currencyName + ", date: " + date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        ResponseEntity<PageInfo<ExchangeRate>> responseEntity;
        try {
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("currencyName", currencyName);
            if (!StringUtils.isEmpty(date)) {
                Date publishDate = dateFormat.parse(date);
                String startTime = timeFormat.format(TimeUtil.getDateStartTime(publishDate));
                String endTime = timeFormat.format(TimeUtil.getDateEndTime(publishDate));
                paramMap.put("startTime", startTime);
                paramMap.put("endTime", endTime);
                logger.info("[getExchangeRatePageInfo], startTime: " + startTime);
                logger.info("[getExchangeRatePageInfo], endTime: " + endTime);
            }
            PageInfo<ExchangeRate> exchangeRatePageInfo = exchangeRateService.getExchangeRatePageInfo(page, limit, paramMap);
            responseEntity = new ResponseEntity<>(exchangeRatePageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
