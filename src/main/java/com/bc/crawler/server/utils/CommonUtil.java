package com.bc.crawler.server.utils;

import com.bc.crawler.server.entity.HotExchange;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 通用工具类
 *
 * @author zhou
 */
public class CommonUtil {

    private static final String HTML_PREFIX_BEGIN = "<span style=\"";
    private static final String HTML_PREFIX_END = "\">";
    private static final String HTML_SUFFIX = "</span>";

    /**
     * 生成主键
     *
     * @return 主键
     */
    public static String generateId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 处理热门汇率
     *
     * @param hotExchange 热门汇率
     * @return 处理后的热门汇率
     */
    public static HotExchange handleHotExchange(HotExchange hotExchange) {
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
