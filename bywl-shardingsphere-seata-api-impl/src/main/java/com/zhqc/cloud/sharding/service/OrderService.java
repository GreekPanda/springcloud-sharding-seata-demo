package com.zhqc.cloud.sharding.service;

import com.zhqc.cloud.sharding.model.po.OrderPOExt;
import com.zhqc.cloud.sharding.model.query.OrderQuery;
import com.zhqc.cloud.sharding.model.req.OrderReq;
import com.zhqc.cloud.sharding.model.req.OrderReqExt;
import com.zhqc.framerwork.common.service.ICrudService;
import com.zhqc.cloud.sharding.model.po.OrderPO;

import java.util.List;

/**
 * @version 1.2.9
 * @类说明: 表注释缺失, 请按规范填写Service
 * @author: GreekPanda
 * @createTime: 2021/12/21
 * @updateAuthor: [修改作者]
 * @UpdateRemark: [说明本次修改内容]
 */
public interface OrderService extends ICrudService<OrderPO> {
    List<OrderPOExt> selectByUserId(OrderQuery orderQuery);

    OrderPOExt addWithItem(OrderReqExt req);
}

