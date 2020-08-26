package com.bc.crawler.server.mapper;

import com.bc.crawler.server.entity.ExchangeRate;

import java.util.List;
import java.util.Map;

/**
 * 汇率
 *
 * @author zhou
 */
public interface ExchangeRateMapper {
    /**
     * 获取汇率列表
     *
     * @param paramMap 参数map
     * @return 汇率列表
     */
    List<ExchangeRate> getExchangeRateList(Map<String, String> paramMap);
}
