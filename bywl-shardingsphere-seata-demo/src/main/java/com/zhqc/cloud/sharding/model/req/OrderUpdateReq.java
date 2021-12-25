package com.zhqc.cloud.sharding.model.req;

import com.zhqc.framerwork.common.model.req.EditReq;
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
public class OrderUpdateReq extends EditReq {
    /**
     * order_id
     */
    private BigInteger orderId;

    /**
     * order_no
     */
    private String orderNo;

    /**
     * user_id#
     */
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