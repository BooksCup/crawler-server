package com.bc.crawler.server.service;

import com.bc.crawler.server.entity.ExchangeRate;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 实时汇率
 *
 * @author zhou
 */
public interface ExchangeRateService {

    /**
     * 获取币种列表
     *
     * @return 币种列表
     */
    List<String> getCurrencyList();

    /**
     * 获取实时汇率分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 实时汇率分页信息
     */
    PageInfo<ExchangeRate> getExchangeRatePageInfo(int pageNum, int pageSize, Map<String, String> paramMap);

}
