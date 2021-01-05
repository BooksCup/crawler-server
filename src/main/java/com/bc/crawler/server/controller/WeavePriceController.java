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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 纺织品价格趋势
 *
 * @author zhou
 */
@RestController
@RequestMapping("/weavePrice")
public class WeavePriceController {

    private static final Logger logger = LoggerFactory.getLogger(WeavePriceController.class);

    @Resource
    WeavePriceService weavePriceService;

    /**
     * 获取纺织品类型列表
     *
     * @return 纺织品类型列表
     */
    @CrossOrigin
    @ApiOperation(value = "获取纺织品类型列表", notes = "获取纺织品类型列表")
    @GetMapping(value = "/type")
    public ResponseEntity<List<String>> getWeaveTypeList() {
        logger.info("[getWeaveTypeList]");
        ResponseEntity<List<String>> responseEntity;
        try {
            List<String> weaveTypeList = weavePriceService.getWeaveTypeList();
            responseEntity = new ResponseEntity<>(weaveTypeList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 获取纺织品价格分页信息
     *
     * @param name  名称
     * @param type  类型
     * @param date  报价日期
     * @param page  当前分页数
     * @param limit 分页大小
     * @return 纺织品价格分页信息
     */
    @CrossOrigin
    @ApiOperation(value = "获取纺织品价格分页信息", notes = "获取纺织品价格分页信息")
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<WeavePrice>> getWeavePricePageInfo(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String date,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        logger.info("[getWeavePricePageInfo], page: " + page + ", limit: " + limit + ", name: " + name
                + ", type: " + type + ", date: " + date);
        ResponseEntity<PageInfo<WeavePrice>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("name", name);
            paramMap.put("type", type);
            paramMap.put("date", date);
            PageInfo<WeavePrice> weavePricePageInfo = weavePriceService.getWeavePricePageInfo(page, limit, paramMap);
            responseEntity = new ResponseEntity<>(weavePricePageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 获取纺织品价格列表
     *
     * @param name 名称
     * @param type 类型
     * @param date 报价日期
     * @return 纺织品价格列表
     */
    @ApiOperation(value = "获取纺织品价格列表", notes = "获取纺织品价格列表")
    @GetMapping(value = "/list")
    public ResponseEntity<List<WeavePrice>> getWeavePriceList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String date) {
        logger.info("[getWeavePriceList], name: " + name + ", type: " + type + ", date: " + date);
        ResponseEntity<List<WeavePrice>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("name", name);
            if (!StringUtils.isEmpty(type)) {
                List<String> typeList = new ArrayList<>();
                typeList.add(Constant.WEAVE_PRICE_TYPE_FIBER);
                typeList.add(Constant.WEAVE_PRICE_TYPE_YARN);
                paramMap.put("typeList", typeList);
            }

            if (!StringUtils.isEmpty(date)) {
                String lastWeavePriceDate = weavePriceService.getLastWeavePriceDate(paramMap);
                paramMap.put("date", lastWeavePriceDate);
            }

            List<WeavePrice> weavePriceList = weavePriceService.getWeavePriceListByMultipleType(paramMap);
            responseEntity = new ResponseEntity<>(weavePriceList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
