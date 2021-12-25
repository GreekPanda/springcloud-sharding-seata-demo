package com.zhqc.cloud.sharding.model.po;

import com.zhqc.framerwork.common.model.po.BasePO;

import java.math.BigInteger;

/**
 * @author GreekPanda 2021/12/21
 * @version 1.2.9
 */
public class OrderPOExt extends OrderPO {
    BigInteger orderItemId;
    String orderItemName;

    public BigInteger getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(BigInteger orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getItemName() {
        return orderItemName;
    }

    public void setItemName(String itemName) {
        this.orderItemName = itemName.trim();
    }
}