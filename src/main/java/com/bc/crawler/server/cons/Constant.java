package com.bc.crawler.server.cons;

/**
 * 常量类
 *
 * @author zhou
 */
public class Constant {

    /**
     * 初始化hashmap容量
     */
    public static final int DEFAULT_HASH_MAP_CAPACITY = 16;

    public static final String SERVICE_TYPE_WEAVE_PRICE = "0";

    // shell脚本执行类型
    /**
     * 手动执行
     */
    public static final String SHELL_EXECUTE_TYPE_ACTIVE = "0";

    /**
     * 定时任务
     */
    public static final String SHELL_EXECUTE_TYPE_CRON = "1";

    // shell脚本执行状态
    /**
     * 脚本执行成功
     */
    public static final String SHELL_EXECUTE_STATUS_SUCCESS = "0";

    /**
     * 脚本执行失败
     */
    public static final String SHELL_EXECUTE_STATUS_FAIL = "1";

    /**
     * 化纤
     */
    public static final String WEAVE_PRICE_TYPE_FIBER = "化纤";

    /**
     * 纱线
     */
    public static final String WEAVE_PRICE_TYPE_YARN = "纱线";
}
