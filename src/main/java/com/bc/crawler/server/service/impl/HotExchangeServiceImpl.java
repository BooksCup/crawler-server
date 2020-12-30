package com.bc.crawler.server.service.impl;

import com.bc.crawler.server.entity.HotExchange;
import com.bc.crawler.server.mapper.HotExchangeMapper;
import com.bc.crawler.server.service.HotExchangeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 热门汇率
 *
 * @author zhou
 */
@Service("hotExchangeService")
public class HotExchangeServiceImpl implements HotExchangeService {

    @Resource
    private HotExchangeMapper hotExchangeMapper;

    /**
     * 获取热门汇率列表
     *
     * @return 热门汇率列表
     */
    @Override
    public List<HotExchange> getHotExchangeList() {
        return hotExchangeMapper.getHotExchangeList();
    }

}
