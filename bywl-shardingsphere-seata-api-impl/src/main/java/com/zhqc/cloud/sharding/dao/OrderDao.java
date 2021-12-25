package com.zhqc.cloud.sharding.dao;

import com.zhqc.cloud.sharding.model.po.OrderPO;
import com.zhqc.cloud.sharding.model.po.OrderPOExt;
import com.zhqc.cloud.sharding.model.query.OrderQuery;
import com.zhqc.cloud.sharding.model.req.OrderReq;
import com.zhqc.cloud.sharding.model.req.OrderReqExt;
import com.zhqc.framerwork.common.dao.ICrudDAO;

import java.util.List;

public interface OrderDao extends ICrudDAO<OrderPO> {
    List<OrderPOExt> selectByUserId(OrderQuery orderQuery);
    List<OrderPOExt> selectByOrderId(OrderReqExt orderQuery);
}