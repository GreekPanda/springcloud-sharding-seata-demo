package com.zhqc.cloud.sharding.model.dto.sharding;

import java.math.BigInteger;

/**
 * TODO
 *
 * @author liaoh
 * @version 1.0
 * @date 2021/12/23 12:59
 */

public class OrderItemReqDTO {
    /**
     * order_item_id
     */
    private BigInteger orderItemId;

    /**
     * order_id
     */
    private BigInteger orderId;

    /**
     * item_name
     */
    private String itemName;

    /**
     * user_id#
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
