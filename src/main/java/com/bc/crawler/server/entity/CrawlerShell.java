package com.bc.crawler.server.entity;


import com.bc.crawler.server.utils.CommonUtil;

/**
 * 爬虫脚本
 *
 * @author zhou
 */
public class CrawlerShell {

    private String id;
    private String serviceType;
    private String path;
    private String createTime;
    private String modifyTime;

    public CrawlerShell() {

    }

    public CrawlerShell(String serviceType, String path) {
        this.id = CommonUtil.generateId();
        this.serviceType = serviceType;
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
