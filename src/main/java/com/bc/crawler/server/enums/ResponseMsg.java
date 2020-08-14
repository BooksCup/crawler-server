package com.bc.crawler.server.enums;

/**
 * 返回消息
 *
 * @author zhou
 */
public enum ResponseMsg {
    /**
     * crawler-server接口返回信息
     */
    EXECUTE_CRAWLER_SUCCESS("EXECUTE_CRAWLER_SUCCESS", "执行爬虫脚本成功"),
    EXECUTE_CRAWLER_ERROR("EXECUTE_CRAWLER_ERROR", "执行爬虫脚本失败"),
    ;

    ResponseMsg(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    private String responseCode;
    private String responseMessage;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
