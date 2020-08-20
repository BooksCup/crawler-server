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
    CRAWLER_SHELL_EXISTS("CRAWLER_SHELL_EXISTS", "爬虫脚本已存在"),
    CRAWLER_SHELL_NOT_EXISTS("CRAWLER_SHELL_NOT_EXISTS", "爬虫脚本不存在"),

    EXECUTE_CRAWLER_SUCCESS("EXECUTE_CRAWLER_SUCCESS", "执行爬虫脚本成功"),
    EXECUTE_CRAWLER_ERROR("EXECUTE_CRAWLER_ERROR", "执行爬虫脚本失败"),

    UPDATE_CRAWLER_SUCCESS("UPDATE_CRAWLER_SUCCESS", "修改爬虫脚本成功"),
    UPDATE_CRAWLER_ERROR("UPDATE_CRAWLER_ERROR", "修改爬虫脚本失败"),

    DELETE_CRAWLER_SUCCESS("DELETE_CRAWLER_SUCCESS", "删除爬虫脚本成功"),
    DELETE_CRAWLER_ERROR("DELETE_CRAWLER_ERROR", "删除爬虫脚本失败"),
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
