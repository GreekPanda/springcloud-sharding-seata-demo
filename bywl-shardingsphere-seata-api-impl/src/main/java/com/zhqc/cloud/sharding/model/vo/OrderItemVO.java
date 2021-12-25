package com.zhqc.cloud.sharding.model.vo;

import com.zhqc.framerwork.common.model.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigInteger;

/**
 * @author GreekPanda 2021/12/21
 * @version 1.2.9
 */
@ApiModel
public class OrderItemVO extends BaseVO {
    /**
     * order_item_id
     */
    @ApiModelProperty(value = "order_item_id,必填,长度19", required = true, dataType = "java.math.BigInteger")
    private BigInteger orderItemId;

    /**
     * order_id
     */
    @ApiModelProperty(value = "order_id,长度19", dataType = "java.math.BigInteger")
    private BigInteger orderId;

    /**
     * item_name
     */
    @ApiModelProperty(value = "item_name,长度50", dataType = "java.lang.String")
    private String itemName;

    /**
     * user_id#
     */
    @ApiModelProperty(value = "user_id#,长度19", dataType = "java.math.BigInteger")
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