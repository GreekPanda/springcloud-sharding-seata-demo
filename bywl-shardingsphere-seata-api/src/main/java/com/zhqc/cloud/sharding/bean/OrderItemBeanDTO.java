package com.zhqc.cloud.sharding.bean;

import java.math.BigInteger;
import java.util.List;

/**
 * TODO
 *
 * @author liaoh
 * @version 1.0
 * @date 2021/12/23 16:12
 */

public class OrderItemBeanDTO {

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
        this.itemName = itemName;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
}
