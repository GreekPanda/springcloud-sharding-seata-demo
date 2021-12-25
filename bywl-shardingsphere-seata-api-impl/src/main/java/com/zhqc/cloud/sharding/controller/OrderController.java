package com.zhqc.cloud.sharding.controller;

import com.alibaba.fastjson.JSON;
import com.zhqc.cloud.sharding.model.dto.sharding.OrderItemReqDTO;
import com.zhqc.cloud.sharding.model.dto.sharding.OrderReqDTO;
import com.zhqc.cloud.sharding.model.po.OrderPO;
import com.zhqc.cloud.sharding.model.po.OrderPOExt;
import com.zhqc.cloud.sharding.model.req.OrderItemReq;
import com.zhqc.cloud.sharding.model.req.OrderReqExt;
import com.zhqc.cloud.sharding.model.req.OrderUpdateReq;
import com.zhqc.cloud.sharding.model.req.OrderReq;
import com.zhqc.cloud.sharding.model.query.OrderQuery;
import com.zhqc.cloud.sharding.model.vo.OrderVO;
import com.zhqc.cloud.sharding.service.OrderItemService;
import com.zhqc.cloud.sharding.service.OrderService;
import com.zhqc.cloud.sharding.convert.OrderConvert;
import com.zhqc.framerwork.common.model.vo.PageResponseVO;
import com.zhqc.framerwork.common.model.vo.BusinessResponseVO;
import com.zhqc.framerwork.common.model.vo.ResponseVO;
import com.zhqc.framerwork.common.controller.DefaultCrudController;
import com.zhqc.framerwork.common.util.GeneratorUtil;
import com.zhqc.framerwork.common.util.PoJoCopyUtils;
import io.seata.common.util.CollectionUtils;
import io.swagger.annotations.*;
import jodd.util.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.2.9
 * @类说明: 表注释缺失, 请按规范填写Controller
 * @author: GreekPanda
 * @createTime: 2021/12/21
 * @updateAuthor: [修改作者]
 * @UpdateRemark: [说明本次修改内容]
 */
@RestController
@RequestMapping("/sharding/order")
@Api(value = "表注释缺失,请按规范填写")
@Slf4j
public class OrderController extends DefaultCrudController<OrderVO, OrderQuery, OrderReq, OrderUpdateReq, OrderService, OrderConvert> {

    @Resource
    @Lazy
    private OrderService orderService;

    @Resource
    @Lazy
    private PoJoCopyUtils poJoCopyUtils;

    @ApiOperation(value = "页面初始化操作")
    @PostMapping(value = "/initPage")
    public BusinessResponseVO initPage() {
        return super.initPage();
    }

    @ApiOperation(value = "查询表注释缺失,请按规范填写")
    @PostMapping(value = "/pageInfo")
    public PageResponseVO<OrderVO> pageInfo(@RequestBody @Validated OrderQuery query) {
        return super.pageInfo(query);
    }

    @ApiOperation(value = "新增时初始化操作")
    @PostMapping(value = "/initAdd/{orderId}")
    public BusinessResponseVO initAdd(@ApiParam(value = "主键", required = true) @PathVariable("orderId") BigInteger orderId) {
        return super.initAdd(orderId);
    }

    @ApiOperation(value = "修改时初始化操作")
    //@PreAuthorize("hasRole('BYWL_CLOUD_SHARDINGSPHERE_SEATA_DEMO_SHARDING_ORDER_EDIT')")
    @PostMapping(value = "/initUpdate/{orderId}")
    public BusinessResponseVO initUpdate(@ApiParam(value = "主键", required = true) @PathVariable("orderId") BigInteger orderId) {
        return super.initUpdate(orderId);
    }

    @ApiOperation(value = "新增表注释缺失,请按规范填写")
    //@PreAuthorize("hasRole('BYWL_CLOUD_SHARDINGSPHERE_SEATA_DEMO_SHARDING_ORDER_ADD')")
    @PostMapping(value = "/add")
    public ResponseVO add(@RequestBody @Validated OrderReq req) {
        super.add(req);
        return ResponseVO.SYS_SUCCESS;
    }

    @ApiOperation(value = "修改表注释缺失,请按规范填写")
    //@PreAuthorize("hasRole('BYWL_CLOUD_SHARDINGSPHERE_SEATA_DEMO_SHARDING_ORDER_EDIT')")
    @PostMapping(value = "/update")
    public ResponseVO update(@RequestBody @Validated OrderUpdateReq req) {
        super.update(req);
        return ResponseVO.SYS_SUCCESS;
    }

    @ApiOperation(value = "删除表注释缺失,请按规范填写")
    //@PreAuthorize("hasRole('BYWL_CLOUD_SHARDINGSPHERE_SEATA_DEMO_SHARDING_ORDER_DELETE')")
    @PostMapping(value = "/delete/{orderId}")
    public ResponseVO delete(@ApiParam(value = "主键", required = true) @PathVariable("orderId") BigInteger orderId) {
        super.delete(orderId);
        return ResponseVO.SYS_SUCCESS;
    }

    @ApiOperation(value = "增加订单表和订单明细")
    @PostMapping(value = "/addWithItem")
    public BusinessResponseVO<OrderPOExt> addWithItem(@RequestBody @Validated OrderReqDTO req) {
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@Req: {}", JSON.toJSONString(req));
        OrderReqExt orderReqExt = poJoCopyUtils.convert(req, OrderReqExt.class);
        List<OrderItemReq> orderItemReqList = new ArrayList<>();
        for(OrderItemReqDTO orderItemReqDTO : req.getOrderItemReqDTOList()) {
            OrderItemReq orderItemReq = poJoCopyUtils.convert(orderItemReqDTO, OrderItemReq.class);
            orderItemReqList.add(orderItemReq);
        }
        orderReqExt.setOrderItemReqList(orderItemReqList);
        log.info("####################orderReqExt: {}", JSON.toJSONString(orderReqExt));
        OrderPOExt orderPOExt = orderService.addWithItem(orderReqExt);
        if (orderPOExt != null) {
            return BusinessResponseVO.buildSuccessVo(orderPOExt);
        } else {
            return BusinessResponseVO.buildFailVo("error");
        }
    }

}

