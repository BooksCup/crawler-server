package com.bc.crawler.server.mapper;

import com.bc.crawler.server.entity.HotExchange;

import java.util.List;
import java.util.Map;

/**
 * 热门汇率
 *
 * @author zhou
 */
public interface HotExchangeMapper {

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
