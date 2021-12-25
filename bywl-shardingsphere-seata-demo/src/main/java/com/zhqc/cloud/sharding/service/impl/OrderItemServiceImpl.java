package com.zhqc.cloud.sharding.service.impl;

import com.zhqc.framerwork.common.model.req.AddReq;
import com.zhqc.framerwork.common.model.req.EditReq;

import com.zhqc.cloud.sharding.service.OrderItemService;
import com.zhqc.cloud.sharding.dao.OrderItemDao;
import com.zhqc.cloud.sharding.model.po.OrderItemPO;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.zhqc.framerwork.common.service.DefaultCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version 1.2.9
 * @类说明: 表注释缺失, 请按规范填写Service
 * @author: liaohuanghe
 * @createTime: 2021/12/21
 * @updateAuthor: [修改作者]
 * @UpdateRemark: [说明本次修改内容]
 */
@Service("orderItemService")
@Transactional
public class OrderItemServiceImpl extends DefaultCrudService<OrderItemPO, OrderItemDao> implements OrderItemService {
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
     * @param id orderItemId
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
     * @param id orderItemId
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
     * @param req OrderItemReq
     */
    @Override
    protected void checkAddData(AddReq req) {
    }

    /**
     * 新增保存数据库之前业务处理（新增时间和新增人框架已经封装，这里不用处理）
     *
     * @param po  OrderItemPO 已新增需要保存数据库中的PO对象
     * @param req OrderItemReq 新增数据
     */
    @Override
    protected void preForAdd(OrderItemPO po, AddReq req) {
        //新增之前业务处理
    }

    /**
     * 新增保存数据库之后业务处理
     *
     * @param po  OrderItemPO 增加后数据库中的PO对象
     * @param req OrderItemReq 新增数据
     */
    @Override
    protected void postForAdd(OrderItemPO po, AddReq req) {
        //新增之后业务处理
    }

    /**
     * 修改之前数据校验 在preForUpdate方法执行之前执行
     *
     * @param po  OrderItemPO 修改之前数据库中的PO对象
     * @param req OrderItemUpdateReq 要修改的数据
     */
    @Override
    protected void checkEditData(OrderItemPO po, EditReq req) {
    }

    /**
     * 修改保存数据库之前业务处理（修改时间和修改人框架已经封装，这里不用处理）
     *
     * @param po  OrderItemPO 已修改需要报存数据库中的PO对象
     * @param req OrderItemUpdateReq 要修改的数据
     */
    @Override
    protected void preForUpdate(OrderItemPO po, EditReq req) {
        //修改之前业务处理
    }

    /**
     * 修改保存数据库之后业务处理
     *
     * @param po  OrderItemPO 修改后数据库中的PO对象
     * @param req OrderItemUpdateReq 要修改的数据
     */
    @Override
    protected void postForUpdate(OrderItemPO po, EditReq req) {
        //修改之后业务处理
    }

    /**
     * 删除之前业务处理
     *
     * @param id orderItemId
     */
    @Override
    protected void preForDelete(BigInteger id) {
        //删除之前业务处理
    }

    /**
     * 删除之后业务处理
     *
     * @param id orderItemId
     */
    @Override
    protected void postForDelete(BigInteger id) {
        //删除之后业务处理
    }


}
