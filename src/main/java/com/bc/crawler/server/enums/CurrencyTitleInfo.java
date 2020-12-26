package com.bc.crawler.server.enums;

/**
 * 货币标题信息
 *
 * @author zhou
 */
public enum CurrencyTitleInfo {

    USD("美元", "美元兑人民币[USDCNY]"),
    ;

    CurrencyTitleInfo(String currency, String currencyTitle) {
        this.currency = currency;
        this.currencyTitle = currencyTitle;
    }

    private String currency;
    private String currencyTitle;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyTitle() {
        return currencyTitle;
    }

    public void setCurrencyTitle(String currencyTitle) {
        this.currencyTitle = currencyTitle;
    }

    public static String getCurrencyTitleByCurrency(String currency) {
        CurrencyTitleInfo[] currencyTitleInfos = values();
        for (CurrencyTitleInfo currencyTitleInfo : currencyTitleInfos) {
            if (currencyTitleInfo.getCurrency().equals(currency)) {
                return currencyTitleInfo.getCurrencyTitle();
            }
        }
        return null;
    }

}
