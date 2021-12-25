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
public class OrderItemQuery extends BaseQuery {
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

    @Override
    public List<String> getSearchType() {
        List<String> list = new ArrayList<>();
        list.add("EQ_orderItemId");
        list.add("EQ_orderId");
        list.add("EQ_itemName");
        list.add("EQ_userId");
        return list;
    }
}