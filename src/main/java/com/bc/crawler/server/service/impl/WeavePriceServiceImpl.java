package com.bc.crawler.server.service.impl;

import com.bc.crawler.server.entity.WeavePrice;
import com.bc.crawler.server.mapper.WeavePriceMapper;
import com.bc.crawler.server.service.WeavePriceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 纺织品价格趋势
 *
 * @author zhou
 */
@Service("weavePriceService")
public class WeavePriceServiceImpl implements WeavePriceService {

    @Resource
    private WeavePriceMapper weavePriceMapper;

    /**
     * 获取纺织品类型列表
     *
     * @return 纺织品类型列表
     */
    @Override
    public List<String> getWeaveTypeList() {
        return weavePriceMapper.getWeaveTypeList();
    }

    /**
     * 获取纺织品价格分页信息
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 纺织品价格分页信息
     */
    @Override
    public PageInfo<WeavePrice> getWeavePricePageInfo(int pageNum, int pageSize, Map<String, String> paramMap) {
        PageHelper.startPage(pageNum, pageSize);
        List<WeavePrice> weavePriceList = weavePriceMapper.getWeavePriceList(paramMap);
        return new PageInfo<>(weavePriceList);
    }

    /**
     * 获取纺织品价格列表
     *
     * @param paramMap 参数map
     * @return 纺织品价格列表
     */
    @Override
    public List<WeavePrice> getWeavePriceList(Map<String, String> paramMap) {
        return weavePriceMapper.getWeavePriceList(paramMap);
    }

    /**
     * 获取最后一次交易日期
     *
     * @param paramMap 参数map
     * @return 最后一次交易日期
     */
    @Override
    public String getLastWeavePriceDate(Map<String, String> paramMap) {
        return weavePriceMapper.getLastWeavePriceDate(paramMap);
    }

}
