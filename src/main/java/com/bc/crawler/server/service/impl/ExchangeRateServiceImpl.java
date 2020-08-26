package com.bc.crawler.server.service.impl;

import com.bc.crawler.server.entity.ExchangeRate;
import com.bc.crawler.server.mapper.ExchangeRateMapper;
import com.bc.crawler.server.service.ExchangeRateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 汇率
 *
 * @author zhou
 */
@Service("exchangeRateService")
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Resource
    private ExchangeRateMapper exchangeRateMapper;

    /**
     * 获取汇率分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 汇率分页信息
     */
    @Override
    public PageInfo<ExchangeRate> getExchangeRatePageInfo(int pageNum, int pageSize, Map<String, String> paramMap) {
        PageHelper.startPage(pageNum, pageSize);
        List<ExchangeRate> exchangeRateList = exchangeRateMapper.getExchangeRateList(paramMap);
        return new PageInfo<>(exchangeRateList);
    }

}
