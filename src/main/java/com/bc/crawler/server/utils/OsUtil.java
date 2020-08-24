package com.bc.crawler.server.utils;

import java.net.InetAddress;
import java.util.Properties;

/**
 * 操作系统工具类
 *
 * @author zhou
 */
public class OsUtil {
    /**
     * 获取操作系统名
     *
     * @return 操作系统名
     */
    public static String getOsName() {
        Properties props = System.getProperties();
        return props.getProperty("os.name");
    }

    /**
     * 获取IP地址
     *
     * @return IP地址
     */
    public static String getIp() {
        String ip;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            ip = inetAddress.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            ip = "";
        }
        return ip;
    }
}
