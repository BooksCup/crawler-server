package com.bc.crawler.server.mapper;

import com.bc.crawler.server.entity.ForwardExchange;

import java.util.List;
import java.util.Map;

/**
 * 远期汇率
 *
 * @author zhou
 */
public interface ForwardExchangeMapper {

    /**
     * 获取币种列表
     *
     * @return 币种列表
     */
    List<String> getCurrencyList();

    /**
     * 获取远期汇率列表
     *
     * @param paramMap 参数map
     * @return 远期汇率列表
     */
    List<ForwardExchange> getForwardExchangeList(Map<String, String> paramMap);
}
