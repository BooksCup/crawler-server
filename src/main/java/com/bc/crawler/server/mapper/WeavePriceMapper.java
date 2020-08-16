package com.bc.crawler.server.mapper;

import com.bc.crawler.server.entity.WeavePrice;

import java.util.List;
import java.util.Map;

/**
 * 纺织品价格趋势
 *
 * @author zhou
 */
public interface WeavePriceMapper {

    /**
     * 获取纺织品类型列表
     *
     * @return 纺织品类型列表
     */
    List<String> getWeaveTypeList();

    /**
     * 获取纺织品价格列表
     *
     * @param paramMap 参数map
     * @return 纺织品价格列表
     */
    List<WeavePrice> getWeavePriceList(Map<String, String> paramMap);
}
