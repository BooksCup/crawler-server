package com.bc.crawler.server.mapper;

import com.bc.crawler.server.entity.HotExchange;

import java.util.List;

/**
 * 热门汇率
 *
 * @author zhou
 */
public interface HotExchangeMapper {

    /**
     * 获取热门汇率列表
     *
     * @return 热门汇率列表
     */
    List<HotExchange> getHotExchangeList();

}
