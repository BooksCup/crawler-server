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
import org.springframework.util.StringUtils;
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
    private static final String HTML_PREFIX_BEGIN = "<span style=\"";
    private static final String HTML_PREFIX_END = "\">";
    private static final String HTML_SUFFIX = "</span>";

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
                HotExchange hotExchange = hotExchangeList.get(0);
                hotExchange = handleHotExchange(hotExchange);
                dataProfile.setHotExchange(hotExchange);
            }

            responseEntity = new ResponseEntity<>(dataProfile, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new DataProfile(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 处理热门汇率
     *
     * @param hotExchange 热门汇率
     * @return 处理后的热门汇率
     */
    private HotExchange handleHotExchange(HotExchange hotExchange) {
        StringBuffer currentPriceHtmlBuffer = new StringBuffer();
        StringBuffer changeHtmlBuffer = new StringBuffer();
        StringBuffer todayPriceHtmlBuffer = new StringBuffer();
        StringBuffer yesterdayPriceHtmlBuffer = new StringBuffer();
        StringBuffer highestPriceHtmlBuffer = new StringBuffer();
        StringBuffer lowestPriceHtmlBuffer = new StringBuffer();
        if (StringUtils.isEmpty(hotExchange.getTitleCss())) {
            currentPriceHtmlBuffer.append(hotExchange.getCurrentPrice());
            changeHtmlBuffer.append(hotExchange.getChange());
        } else {
            currentPriceHtmlBuffer.append(HTML_PREFIX_BEGIN).append(hotExchange.getTitleCss()).append(HTML_PREFIX_END)
                    .append(hotExchange.getCurrentPrice()).append(HTML_SUFFIX);
            changeHtmlBuffer.append(HTML_PREFIX_BEGIN).append(hotExchange.getTitleCss()).append(HTML_PREFIX_END)
                    .append(hotExchange.getChange()).append(HTML_SUFFIX);
        }

        if (StringUtils.isEmpty(hotExchange.getTodayPriceCss())) {
            todayPriceHtmlBuffer.append(hotExchange.getTodayPrice());
        } else {
            todayPriceHtmlBuffer.append(HTML_PREFIX_BEGIN).append(hotExchange.getTodayPriceCss()).append(HTML_PREFIX_END)
                    .append(hotExchange.getTodayPrice()).append(HTML_SUFFIX);
        }

        if (StringUtils.isEmpty(hotExchange.getYesterdayPriceCss())) {
            yesterdayPriceHtmlBuffer.append(hotExchange.getYesterdayPrice());
        } else {
            yesterdayPriceHtmlBuffer.append(HTML_PREFIX_BEGIN).append(hotExchange.getYesterdayPriceCss()).append(HTML_PREFIX_END)
                    .append(hotExchange.getYesterdayPrice()).append(HTML_SUFFIX);
        }

        if (StringUtils.isEmpty(hotExchange.getHighestPriceCss())) {
            highestPriceHtmlBuffer.append(hotExchange.getHighestPrice());
        } else {
            highestPriceHtmlBuffer.append(HTML_PREFIX_BEGIN).append(hotExchange.getHighestPriceCss()).append(HTML_PREFIX_END)
                    .append(hotExchange.getHighestPrice()).append(HTML_SUFFIX);
        }

        if (StringUtils.isEmpty(hotExchange.getLowestPriceCss())) {
            lowestPriceHtmlBuffer.append(hotExchange.getLowestPrice());
        } else {
            lowestPriceHtmlBuffer.append(HTML_PREFIX_BEGIN).append(hotExchange.getLowestPriceCss()).append(HTML_PREFIX_END)
                    .append(hotExchange.getLowestPrice()).append(HTML_SUFFIX);
        }
        hotExchange.setCurrentPriceHtml(currentPriceHtmlBuffer.toString());
        hotExchange.setChangeHtml(changeHtmlBuffer.toString());
        hotExchange.setCurrentPriceHtml(currentPriceHtmlBuffer.toString());
        hotExchange.setTodayPriceHtml(todayPriceHtmlBuffer.toString());
        hotExchange.setYesterdayPriceHtml(yesterdayPriceHtmlBuffer.toString());
        hotExchange.setHighestPriceHtml(highestPriceHtmlBuffer.toString());
        hotExchange.setLowestPriceHtml(lowestPriceHtmlBuffer.toString());
        return hotExchange;
    }

}
