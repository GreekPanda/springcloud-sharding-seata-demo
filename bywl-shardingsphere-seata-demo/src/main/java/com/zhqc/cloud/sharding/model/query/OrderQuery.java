package com.zhqc.cloud.sharding.model.query;

import com.zhqc.framerwork.common.model.query.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

/**
 * @author liaohuanghe 2021/12/21
 * @version 1.2.9
 */
@ApiModel
public class OrderQuery extends BaseQuery {
    /**
     * order_id
     */
    private Long orderId;

    /**
     * order_no
     */
    private String orderNo;

    /**
     * user_id#
     */
    private BigInteger userId;

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
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    @Override
    public List<String> getSearchType() {
        List<String> list = new ArrayList<>();
        list.add("EQ_orderId");
        list.add("EQ_orderNo");
        list.add("EQ_userId");
        return list;
    }
}