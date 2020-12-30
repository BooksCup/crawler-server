package com.bc.crawler.server.controller;

import com.bc.crawler.server.cons.Constant;
import com.bc.crawler.server.entity.DataProfile;
import com.bc.crawler.server.entity.HotExchange;
import com.bc.crawler.server.entity.WeavePrice;
import com.bc.crawler.server.service.HotExchangeService;
import com.bc.crawler.server.service.WeavePriceService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 数据信息
 *
 * @author zhou
 */
@RestController
@RequestMapping("/dataProfile")
public class DataProfileController {

    private static final Logger logger = LoggerFactory.getLogger(WeavePriceController.class);

    @Resource
    WeavePriceService weavePriceService;

    @Resource
    HotExchangeService hotExchangeService;

    /**
     * 获取数据信息
     *
     * @return 数据信息
     */
    @ApiOperation(value = "获取数据信息", notes = "获取数据信息")
    @GetMapping(value = "")
    public ResponseEntity<DataProfile> getDataProfile() {
        logger.info("[getDateProfile]");
        ResponseEntity<DataProfile> responseEntity;
        DataProfile dataProfile = new DataProfile();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Map<String, String> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("type", "化纤");
            paramMap.put("date", simpleDateFormat.format(new Date()));
            List<WeavePrice> weavePriceList = weavePriceService.getWeavePriceList(paramMap);

            dataProfile.setWeavePriceList(weavePriceList);

            List<HotExchange> hotExchangeList = hotExchangeService.getHotExchangeList();
            if (!CollectionUtils.isEmpty(hotExchangeList)) {
                dataProfile.setHotExchange(hotExchangeList.get(0));
            }

            responseEntity = new ResponseEntity<>(dataProfile, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new DataProfile(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
