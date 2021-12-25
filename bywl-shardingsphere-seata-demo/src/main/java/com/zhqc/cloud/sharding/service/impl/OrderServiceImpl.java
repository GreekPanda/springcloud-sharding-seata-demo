package com.zhqc.cloud.sharding.service.impl;


import com.alibaba.fastjson.JSON;
import com.zhqc.cloud.sharding.bean.OrderBeanDTO;
import com.zhqc.cloud.sharding.model.dto.sharding.OrderItemReqDTO;
import com.zhqc.cloud.sharding.model.dto.sharding.OrderReqDTO;
import com.zhqc.cloud.sharding.model.po.OrderPOExt;
import com.zhqc.cloud.sharding.model.query.OrderQuery;
import com.zhqc.cloud.sharding.model.req.OrderItemReq;
import com.zhqc.cloud.sharding.model.req.OrderReqExt;
import com.zhqc.cloud.sharding.order.ShardingSeataFeignApi;
import com.zhqc.framerwork.common.exception.ZhqcValidateException;
import com.zhqc.framerwork.common.model.req.AddReq;
import com.zhqc.framerwork.common.model.req.EditReq;

import com.zhqc.cloud.sharding.service.OrderService;
import com.zhqc.cloud.sharding.dao.OrderDao;
import com.zhqc.cloud.sharding.model.po.OrderPO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhqc.framerwork.common.model.vo.BusinessResponseVO;
import com.zhqc.framerwork.common.service.DefaultCrudService;
import com.zhqc.framerwork.common.util.PoJoCopyUtils;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @version 1.2.9
 * @类说明: 表注释缺失, 请按规范填写Service
 * @author: liaohuanghe
 * @createTime: 2021/12/21
 * @updateAuthor: [修改作者]
 * @UpdateRemark: [说明本次修改内容]
 */
@Service("orderService")
@Transactional
@Slf4j
public class OrderServiceImpl extends DefaultCrudService<OrderPO, OrderDao> implements OrderService {

    @Lazy
    @Resource
    private ShardingSeataFeignApi shardingSeataFeignApi;

    @Resource
    private PoJoCopyUtils poJoCopyUtils;


    /**
     * 页面初始化时业务处理
     *
     * @return Object
     */
    @Override
    public Object initPage() {
        //页面初始化时业务处理
        return null;
    }

    /**
     * 修改页面初始化时业务处理
     *
     * @param id orderId
     * @return Object
     */
    @Override
    public Object initUpdate(BigInteger id) {
        //修改页面初始化时业务处理
        Map resultMap = new HashMap<String, Object>();
        resultMap.put("entity", crudDao.selectByPrimaryKey(id));
        return resultMap;
    }

    /**
     * 新增页面初始化时业务处理
     *
     * @param id orderId
     * @return Object
     */
    @Override
    public Object initAdd(BigInteger id) {
        //新增页面初始化时业务处理
        return null;
    }


    /**
     * 新增之前数据校验，在preForAdd方法执行之前执行
     *
     * @param req OrderReq
     */
    @Override
    protected void checkAddData(AddReq req) {
    }

    /**
     * 新增保存数据库之前业务处理（新增时间和新增人框架已经封装，这里不用处理）
     *
     * @param po  OrderPO 已新增需要保存数据库中的PO对象
     * @param req OrderReq 新增数据
     */
    @Override
    protected void preForAdd(OrderPO po, AddReq req) {
        //新增之前业务处理
    }

    /**
     * 新增保存数据库之后业务处理
     *
     * @param po  OrderPO 增加后数据库中的PO对象
     * @param req OrderReq 新增数据
     */
    @Override
    protected void postForAdd(OrderPO po, AddReq req) {
        //新增之后业务处理
    }

    /**
     * 修改之前数据校验 在preForUpdate方法执行之前执行
     *
     * @param po  OrderPO 修改之前数据库中的PO对象
     * @param req OrderUpdateReq 要修改的数据
     */
    @Override
    protected void checkEditData(OrderPO po, EditReq req) {
    }

    /**
     * 修改保存数据库之前业务处理（修改时间和修改人框架已经封装，这里不用处理）
     *
     * @param po  OrderPO 已修改需要报存数据库中的PO对象
     * @param req OrderUpdateReq 要修改的数据
     */
    @Override
    protected void preForUpdate(OrderPO po, EditReq req) {
        //修改之前业务处理
    }

    /**
     * 修改保存数据库之后业务处理
     *
     * @param po  OrderPO 修改后数据库中的PO对象
     * @param req OrderUpdateReq 要修改的数据
     */
    @Override
    protected void postForUpdate(OrderPO po, EditReq req) {
        //修改之后业务处理
    }

    /**
     * 删除之前业务处理
     *
     * @param id orderId
     */
    @Override
    protected void preForDelete(BigInteger id) {
        //删除之前业务处理
    }

    /**
     * 删除之后业务处理
     *
     * @param id orderId
     */
    @Override
    protected void postForDelete(BigInteger id) {
        //删除之后业务处理
    }

    @Override
    public List<OrderPOExt> selectByUserId(OrderQuery orderReq) {
        if (orderReq != null) {
            return crudDao.selectByUserId(orderReq);
        } else {
            throw new RuntimeException("传入参数为空!");
        }
    }

    @Override
    @GlobalTransactional(timeoutMills = 300000)
    public int addWithItem(OrderReqExt req) {
        String xId = RootContext.getXID();
        log.info("######################### xid: {}", xId);
        log.info("req: {}", JSON.toJSONString(req));
        OrderReqDTO orderReqDTO = poJoCopyUtils.convert(req, OrderReqDTO.class);
        List<OrderItemReqDTO> orderItemReqDTOList = new ArrayList<>();
        for(OrderItemReq orderItemReq : req.getOrderItemReqList()) {
            OrderItemReqDTO orderItemReqDTO = poJoCopyUtils.convert(orderItemReq, OrderItemReqDTO.class);
            orderItemReqDTOList.add(orderItemReqDTO);
        }
        orderReqDTO.setOrderItemReqDTOList(orderItemReqDTOList);
        log.info("orderReqDTO: {}", JSON.toJSONString(orderReqDTO));
        BusinessResponseVO<OrderBeanDTO> orderPOExtBusinessResponseVO = shardingSeataFeignApi.addWithItem(orderReqDTO);
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ZhqcValidateException(700, e.getMessage());
        }
        if (orderPOExtBusinessResponseVO != null && orderPOExtBusinessResponseVO.getObj() != null) {
            log.info("orderPOExtBusinessResponseVO: {}", JSON.toJSONString(orderPOExtBusinessResponseVO.getObj()));
            //创建了异常看是否可以正常回滚
            //int i = 1 / 0;
            return 1;
        }
        return 0;
    }
}
