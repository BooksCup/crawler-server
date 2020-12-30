package com.bc.crawler.server.entity;

/**
 * 热门汇率
 * @author zhou
 */
public class HotExchange {

    private String id;
    private String currencyName;
    private String currentPrice;
    private String change;
    private String todayPrice;
    private String yesterdayPrice;
    private String highestPrice;
    private String lowestPrice;
    private String createTime;
    private String titleCss;
    private String todayPriceCss;
    private String yesterdayPriceCss;
    private String highestPriceCss;
    private String lowestPriceCss;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getTodayPrice() {
        return todayPrice;
    }

    public void setTodayPrice(String todayPrice) {
        this.todayPrice = todayPrice;
    }

    public String getYesterdayPrice() {
        return yesterdayPrice;
    }

    public void setYesterdayPrice(String yesterdayPrice) {
        this.yesterdayPrice = yesterdayPrice;
    }

    public String getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(String highestPrice) {
        this.highestPrice = highestPrice;
    }

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTitleCss() {
        return titleCss;
    }

    public void setTitleCss(String titleCss) {
        this.titleCss = titleCss;
    }

    public String getTodayPriceCss() {
        return todayPriceCss;
    }

    public void setTodayPriceCss(String todayPriceCss) {
        this.todayPriceCss = todayPriceCss;
    }

    public String getYesterdayPriceCss() {
        return yesterdayPriceCss;
    }

    public void setYesterdayPriceCss(String yesterdayPriceCss) {
        this.yesterdayPriceCss = yesterdayPriceCss;
    }

    public String getHighestPriceCss() {
        return highestPriceCss;
    }

    public void setHighestPriceCss(String highestPriceCss) {
        this.highestPriceCss = highestPriceCss;
    }

    public String getLowestPriceCss() {
        return lowestPriceCss;
    }

    public void setLowestPriceCss(String lowestPriceCss) {
        this.lowestPriceCss = lowestPriceCss;
    }

}