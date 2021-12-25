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

public class OrderBeanDTO {
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

    private List<OrderItemBeanDTO> orderItemBeanDTOList;

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
        this.orderNo = orderNo;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public List<OrderItemBeanDTO> getOrderItemBeanDTOList() {
        return orderItemBeanDTOList;
    }

    public void setOrderItemBeanDTOList(List<OrderItemBeanDTO> orderItemBeanDTOList) {
        this.orderItemBeanDTOList = orderItemBeanDTOList;
    }
}
