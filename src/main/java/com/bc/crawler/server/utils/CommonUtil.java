package com.bc.crawler.server.utils;

import com.bc.crawler.server.entity.HotExchange;
import com.bc.crawler.server.enums.CurrencyTitleInfo;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
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

    private static final String RISE_PREFIX = "<span style='color:#f54545'>";
    private static final String FALL_PREFIX = "<span style='color:#0f990f'>";
    private static final String RISE_FALL_SUFFIX = "</span>";

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
        hotExchange.setTitle(CurrencyTitleInfo.getCurrencyTitleByCurrency(hotExchange.getCurrencyName()));
        return hotExchange;
    }

    /**
     * 处理热门汇率(v2)
     *
     * @param hotExchange 热门汇率
     * @return 处理后的热门汇率
     */
    public static HotExchange handleHotExchangeV2(HotExchange hotExchange) {
        BigDecimal change = new BigDecimal(hotExchange.getChange1());
        hotExchange.setChange(hotExchange.getChange1() + " (" + hotExchange.getChange2() + "%)");
        if (change.doubleValue() > 0) {
            // 涨
            hotExchange.setCurrentPrice(RISE_PREFIX + hotExchange.getCurrentPrice() + RISE_FALL_SUFFIX);
            hotExchange.setChange(RISE_PREFIX + hotExchange.getChange1() +
                    " (" + hotExchange.getChange2() + "%)" + RISE_FALL_SUFFIX);
        } else if (change.doubleValue() < 0) {
            // 跌
            hotExchange.setCurrentPrice(FALL_PREFIX + hotExchange.getCurrentPrice() + RISE_FALL_SUFFIX);
            hotExchange.setChange(FALL_PREFIX + hotExchange.getChange1() +
                    " (" + hotExchange.getChange2() + "%)" + RISE_FALL_SUFFIX);
        }

        hotExchange.setTitle(CurrencyTitleInfo.getCurrencyTitleByCurrency(hotExchange.getCurrencyName()));
        return hotExchange;
    }

}
