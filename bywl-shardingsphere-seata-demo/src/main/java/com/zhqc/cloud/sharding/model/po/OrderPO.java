package com.zhqc.cloud.sharding.model.po;

import com.zhqc.framerwork.common.model.po.BasePO;

import java.math.BigInteger;

/**
 * @author liaohuanghe 2021/12/21
 * @version 1.2.9
 */
public class OrderPO extends BasePO {
    /**
     * OrderId
     */
    private Long orderId;

    /**
     * OrderNo
     */
    private String orderNo;

    /**
     * UserId
     */
    private BigInteger userId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
}