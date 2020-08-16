package com.bc.crawler.server.service;

import com.bc.crawler.server.entity.WeavePrice;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 纺织品价格趋势
 *
 * @author zhou
 */
public interface WeavePriceService {

    /**
     * 获取纺织品类型列表
     *
     * @return 纺织品类型列表
     */
    List<String> getWeaveTypeList();

    /**
     * 获取纺织品价格分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 纺织品价格分页信息
     */
    PageInfo<WeavePrice> getWeavePricePageInfo(int pageNum, int pageSize, Map<String, String> paramMap);
}