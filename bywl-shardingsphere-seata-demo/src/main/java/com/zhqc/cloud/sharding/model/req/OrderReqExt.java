package com.zhqc.cloud.sharding.model.req;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author liaohuanghe 2021/12/21
 * @version 1.2.9
 */
@ApiModel
public class OrderReqExt extends OrderReq {
    private List<OrderItemReq> orderItemReqList;

    public List<OrderItemReq> getOrderItemReqList() {
        return orderItemReqList;
    }

    public void setOrderItemReqList(List<OrderItemReq> orderItemReqList) {
        this.orderItemReqList = orderItemReqList;
    }
}