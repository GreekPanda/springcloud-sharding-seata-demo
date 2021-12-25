package com.zhqc.cloud.sharding.model.dto.sharding;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

/**
 * TODO
 *
 * @author liaoh
 * @version 1.0
 * @date 2021/12/23 12:58
 */

public class OrderReqDTO {
    /**
     * OrderId
     */
    @ApiModelProperty( value = "仓库ID,必填",required = true,dataType = "java.math.BigInteger")
    @NotNull(message = "仓库ID不能为空")
    private Long orderId;

    /**
     * OrderNo
     */
    private String orderNo;

    /**
     * UserId
     */
    private BigInteger userId;

    @ApiModelProperty(value = "出库明细", dataType = "java.util.List")
    @NotEmpty(message = "出库明细不能为空")
    @Valid
    List<OrderItemReqDTO> orderItemReqDTOList;

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

    public List<OrderItemReqDTO> getOrderItemReqDTOList() {
        return orderItemReqDTOList;
    }

    public void setOrderItemReqDTOList(List<OrderItemReqDTO> orderItemReqDTOList) {
        this.orderItemReqDTOList = orderItemReqDTOList;
    }
}
