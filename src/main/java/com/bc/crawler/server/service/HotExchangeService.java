package com.bc.crawler.server.service;


import com.bc.crawler.server.entity.HotExchange;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 热门汇率
 *
 * @author zhou
 */
public interface HotExchangeService {

    /**
     * 获取热门汇率列表
     *
     * @return 热门汇率列表
     */
    List<HotExchange> getHotExchangeList();

    /**
     * 获取热门汇率分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @return 热门汇率分页信息
     */
    PageInfo<HotExchange> getHotExchangeList(int pageNum, int pageSize);

}
