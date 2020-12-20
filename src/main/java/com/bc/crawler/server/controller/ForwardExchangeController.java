package com.bc.crawler.server.controller;

import com.bc.crawler.server.cons.Constant;
import com.bc.crawler.server.entity.ForwardExchange;
import com.bc.crawler.server.service.ForwardExchangeService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 远期汇率
 *
 * @author zhou
 */
@CrossOrigin(exposedHeaders = "responseCode")
@RestController
@RequestMapping("/forwardExchange")
public class ForwardExchangeController {

    private static final Logger logger = LoggerFactory.getLogger(ForwardExchangeController.class);

    @Resource
    private ForwardExchangeService forwardExchangeService;

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
            List<String> currencyList = forwardExchangeService.getCurrencyList();
            responseEntity = new ResponseEntity<>(currencyList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 获取远期汇率分页信息
     *
     * @param page  当前分页数
     * @param limit 分页大小
     * @return 远期汇率分页信息
     */
    @ApiOperation(value = "获取远期汇率分页信息", notes = "获取远期汇率分页信息")
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<ForwardExchange>> getForwardExchangePageInfo(
            @RequestParam(required = false) String currencyName,
            @RequestParam(required = false) String date,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        logger.info("[getForwardExchangePageInfo], page: " + page + ", limit: " + limit
                + ", currencyName: " + currencyName + ", date: " + date);
        ResponseEntity<PageInfo<ForwardExchange>> responseEntity;
        try {
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("currencyName", currencyName);
            paramMap.put("publishDate", date);
            PageInfo<ForwardExchange> forwardExchangePageInfo = forwardExchangeService.getForwardExchangeList(page, limit, paramMap);
            responseEntity = new ResponseEntity<>(forwardExchangePageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
