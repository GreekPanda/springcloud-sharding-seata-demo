package com.zhqc.cloud.sharding.model.req;

import com.zhqc.framerwork.common.model.req.AddReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigInteger;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

/**
 * @author liaohuanghe 2021/12/21
 * @version 1.2.9
 */
@ApiModel
public class OrderItemReq extends AddReq {
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
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
}