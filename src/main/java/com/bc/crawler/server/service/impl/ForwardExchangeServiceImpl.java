package com.bc.crawler.server.service.impl;

import com.bc.crawler.server.entity.ForwardExchange;
import com.bc.crawler.server.mapper.ForwardExchangeMapper;
import com.bc.crawler.server.service.ForwardExchangeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 远期汇率
 *
 * @author zhou
 */
@Service("forwardExchangeService")
public class ForwardExchangeServiceImpl implements ForwardExchangeService {

    @Resource
    private ForwardExchangeMapper forwardExchangeMapper;

    /**
     * 获取币种列表
     *
     * @return 币种列表
     */
    @Override
    public List<String> getCurrencyList() {
        return forwardExchangeMapper.getCurrencyList();
    }

    /**
     * 获取远期汇率分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 远期汇率分页信息
     */
    @Override
    public PageInfo<ForwardExchange> getForwardExchangeList(int pageNum, int pageSize, Map<String, String> paramMap) {
        PageHelper.startPage(pageNum, pageSize);
        List<ForwardExchange> forwardExchangeList = forwardExchangeMapper.getForwardExchangeList(paramMap);
        return new PageInfo<>(forwardExchangeList);
    }

}
