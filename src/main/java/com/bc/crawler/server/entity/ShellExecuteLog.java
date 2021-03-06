package com.bc.crawler.server.entity;

import com.bc.crawler.server.utils.CommonUtil;

/**
 * shell执行日志
 *
 * @author zhou
 */
public class ShellExecuteLog {
    private String id;
    private String executeType;
    private String shellServiceType;
    private String executeStatus;
    private String osName;
    private String ip;
    private String content;
    private String createTime;

    public ShellExecuteLog() {

    }

    public ShellExecuteLog(String executeType, String shellServiceType,
                           String content, String osName, String ip) {
        this.id = CommonUtil.generateId();
        this.executeType = executeType;
        this.shellServiceType = shellServiceType;
        this.content = content;
        this.osName = osName;
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExecuteType() {
        return executeType;
    }

    public void setExecuteType(String executeType) {
        this.executeType = executeType;
    }

    public String getShellServiceType() {
        return shellServiceType;
    }

    public void setShellServiceType(String shellServiceType) {
        this.shellServiceType = shellServiceType;
    }

    public String getExecuteStatus() {
        return executeStatus;
    }

    public void setExecuteStatus(String executeStatus) {
        this.executeStatus = executeStatus;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
