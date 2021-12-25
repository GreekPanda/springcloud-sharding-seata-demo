package com.zhqc.cloud.sharding.model.po;

import com.zhqc.framerwork.common.model.po.BasePO;

import java.math.BigInteger;

/**
 * @author liaohuanghe 2021/12/21
 * @version 1.2.9
 */
public class OrderItemPO extends BasePO {
    /**
     * OrderItemId
     */
    private BigInteger orderItemId;

    /**
     * OrderId
     */
    private BigInteger orderId;

    /**
     * ItemName
     */
    private String itemName;

    /**
     * UserId
     */
    private BigInteger userId;

    public BigInteger getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(BigInteger orderItemId) {
        this.orderItemId = orderItemId;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
}