package com.bc.crawler.server.controller;

import com.bc.crawler.server.entity.HotExchange;
import com.bc.crawler.server.service.HotExchangeService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 热门汇率
 *
 * @author zhou
 */
@CrossOrigin(exposedHeaders = "responseCode")
@RestController
@RequestMapping("/hotExchange")
public class HotExchangeController {

    private static final Logger logger = LoggerFactory.getLogger(HotExchangeController.class);

    @Resource
    private HotExchangeService hotExchangeService;

    /**
     * 获取热门汇率分页信息
     *
     * @param page  当前分页数
     * @param limit 分页大小
     * @return 热门汇率分页信息
     */
    @ApiOperation(value = "获取热门汇率分页信息", notes = "获取热门汇率分页信息")
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<HotExchange>> getHotExchangeList(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        logger.info("[getHotExchangeList], page: " + page + ", limit: " + limit);
        ResponseEntity<PageInfo<HotExchange>> responseEntity;
        try {
            PageInfo<HotExchange> hotExchangePageInfo = hotExchangeService.getHotExchangeList(page, limit);
            responseEntity = new ResponseEntity<>(hotExchangePageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
