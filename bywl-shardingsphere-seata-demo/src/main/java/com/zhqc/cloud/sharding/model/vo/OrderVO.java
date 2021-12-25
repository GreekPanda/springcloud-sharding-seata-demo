package com.zhqc.cloud.sharding.model.vo;

import com.zhqc.framerwork.common.model.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigInteger;

/**
 * @author liaohuanghe 2021/12/21
 * @version 1.2.9
 */
@ApiModel
public class OrderVO extends BaseVO {
    /**
     * order_id
     */
    @ApiModelProperty(value = "order_id,必填,长度19", required = true, dataType = "java.math.BigInteger")
    private BigInteger orderId;

    /**
     * order_no
     */
    @ApiModelProperty(value = "order_no,长度50", dataType = "java.lang.String")
    private String orderNo;

    /**
     * user_id#
     */
    @ApiModelProperty(value = "user_id#,长度19", dataType = "java.math.BigInteger")
    private BigInteger userId;

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
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