package com.bc.crawler.server.entity;

import java.util.List;

/**
 * 数据信息
 *
 * @author zhou
 */
public class DataProfile {

    private List<WeavePrice> weavePriceList;

    public List<WeavePrice> getWeavePriceList() {
        return weavePriceList;
    }

    public void setWeavePriceList(List<WeavePrice> weavePriceList) {
        this.weavePriceList = weavePriceList;
    }
}
