package com.bc.crawler.server.mapper;

import com.bc.crawler.server.entity.ExchangeRate;

import java.util.List;
import java.util.Map;

/**
 * 实时汇率
 *
 * @author zhou
 */
public interface ExchangeRateMapper {

    /**
     * 获取币种列表
     *
     * @return 币种列表
     */
    List<String> getCurrencyList();

    /**
     * 获取实时汇率列表
     *
     * @param paramMap 参数map
     * @return 实时汇率列表
     */
    List<ExchangeRate> getExchangeRateList(Map<String, String> paramMap);
}
