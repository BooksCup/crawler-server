package com.bc.crawler.server.service;


import com.bc.crawler.server.entity.HotExchange;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 热门汇率
 *
 * @author zhou
 */
public interface HotExchangeService {

    /**
     * 获取币种列表
     *
     * @return 币种列表
     */
    List<String> getCurrencyList();

    /**
     * 获取热门汇率列表
     *
     * @param paramMap 参数map
     * @return 热门汇率列表
     */
    List<HotExchange> getHotExchangeList(Map<String, Object> paramMap);

    /**
     * 获取热门汇率分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 热门汇率分页信息
     */
    PageInfo<HotExchange> getHotExchangeList(int pageNum, int pageSize, Map<String, Object> paramMap);

    /**
     * 新增热门汇率
     *
     * @param hotExchange 热门汇率
     */
    void addHotExchange(HotExchange hotExchange);

    /**
     * 获取热门汇率列表(v2)
     *
     * @param paramMap 参数map
     * @return 热门汇率列表
     */
    List<HotExchange> getHotExchangeListV2(Map<String, Object> paramMap);

}
