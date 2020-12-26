package com.bc.crawler.server.service.impl;

import com.bc.crawler.server.entity.HotExchange;
import com.bc.crawler.server.mapper.HotExchangeMapper;
import com.bc.crawler.server.service.HotExchangeService;
import com.bc.crawler.server.utils.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
     * 获取币种列表
     *
     * @return 币种列表
     */
    @Override
    public List<String> getCurrencyList() {
        return hotExchangeMapper.getCurrencyList();
    }

    /**
     * 获取热门汇率列表
     * @param paramMap 参数map
     * @return 热门汇率列表
     */
    @Override
    public List<HotExchange> getHotExchangeList(Map<String, String> paramMap) {
        return hotExchangeMapper.getHotExchangeList(paramMap);
    }

    /**
     * 获取热门汇率分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 热门汇率分页信息
     */
    @Override
    public PageInfo<HotExchange> getHotExchangeList(int pageNum, int pageSize, Map<String, String> paramMap) {
        PageHelper.startPage(pageNum, pageSize);
        List<HotExchange> hotExchangeList = hotExchangeMapper.getHotExchangeList(paramMap);
        List<HotExchange> hotExchangeHtmlList = new ArrayList<>();
        for (HotExchange hotExchange : hotExchangeList) {
            hotExchange = CommonUtil.handleHotExchange(hotExchange);
            hotExchangeHtmlList.add(hotExchange);
        }
        return new PageInfo<>(hotExchangeHtmlList);
    }

}
