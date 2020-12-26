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
     * 获取热门汇率列表
     *
     * @param paramMap 参数map
     * @return 热门汇率列表
     */
    List<HotExchange> getHotExchangeList(Map<String, String> paramMap);

}
