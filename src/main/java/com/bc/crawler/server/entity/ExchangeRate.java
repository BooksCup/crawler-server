package com.bc.crawler.server.entity;

/**
 * 汇率
 *
 * @author zhou
 */
public class ExchangeRate {
    private String id;
    /**
     * 币种名
     */
    private String currencyName;

    /**
     * 现汇买入价
     */
    private String currencyBuy;

    /**
     * 现汇卖出价
     */
    private String currencySell;

    /**
     * 现钞买入价
     */
    private String cashBuy;

    /**
     * 现钞卖出价
     */
    private String cashSell;

    /**
     * 中行折算价
     */
    private String middle;

    /**
     * 发布日期
     */
    private String publishDate;

    /**
     * 发布时间
     */
    private String publishTime;

    private String createTime;

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

    public String getCurrencyBuy() {
        return currencyBuy;
    }

    public void setCurrencyBuy(String currencyBuy) {
        this.currencyBuy = currencyBuy;
    }

    public String getCurrencySell() {
        return currencySell;
    }

    public void setCurrencySell(String currencySell) {
        this.currencySell = currencySell;
    }

    public String getCashBuy() {
        return cashBuy;
    }

    public void setCashBuy(String cashBuy) {
        this.cashBuy = cashBuy;
    }

    public String getCashSell() {
        return cashSell;
    }

    public void setCashSell(String cashSell) {
        this.cashSell = cashSell;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
