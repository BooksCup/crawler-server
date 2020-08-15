package com.bc.crawler.server.controller;

import com.bc.crawler.server.cons.Constant;
import com.bc.crawler.server.entity.WeavePrice;
import com.bc.crawler.server.service.WeavePriceService;
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
 * 纺织品价格趋势
 *
 * @author zhou
 */
@CrossOrigin
@RestController
@RequestMapping("/weavePrice")
public class WeavePriceController {

    private static final Logger logger = LoggerFactory.getLogger(WeavePriceController.class);

    @Resource
    WeavePriceService weavePriceService;

    @ApiOperation(value = "获取纺织品价格分页信息", notes = "获取纺织品价格分页信息")
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<WeavePrice>> getWeavePricePageInfo(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String date,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        logger.info("[getWeavePricePageInfo], page: " + page + ", limit: " + limit + ", name: " + name
                + ", date: " + date);
        ResponseEntity<PageInfo<WeavePrice>> responseEntity;
        try {
            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("name", name);
            paramMap.put("date", date);
            PageInfo<WeavePrice> weavePricePageInfo = weavePriceService.getWeavePricePageInfo(page, limit, paramMap);
            responseEntity = new ResponseEntity<>(weavePricePageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
