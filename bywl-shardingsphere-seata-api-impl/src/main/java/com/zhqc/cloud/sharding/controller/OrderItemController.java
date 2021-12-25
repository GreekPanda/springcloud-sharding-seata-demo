package com.zhqc.cloud.sharding.controller;

import com.zhqc.cloud.sharding.model.req.OrderItemUpdateReq;
import com.zhqc.cloud.sharding.model.req.OrderItemReq;
import com.zhqc.cloud.sharding.model.query.OrderItemQuery;
import com.zhqc.cloud.sharding.model.vo.OrderItemVO;
import com.zhqc.cloud.sharding.service.OrderItemService;
import com.zhqc.cloud.sharding.convert.OrderItemConvert;
import com.zhqc.framerwork.common.model.vo.PageResponseVO;
import com.zhqc.framerwork.common.model.vo.BusinessResponseVO;
import com.zhqc.framerwork.common.model.vo.ResponseVO;
import com.zhqc.framerwork.common.controller.DefaultCrudController;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.*;

/**
 * @version 1.2.9
 * @类说明: 表注释缺失, 请按规范填写Controller
 * @author: GreekPanda
 * @createTime: 2021/12/21
 * @updateAuthor: [修改作者]
 * @UpdateRemark: [说明本次修改内容]
 */
@RestController
@RequestMapping("/sharding/orderItem")
@Api(value = "表注释缺失,请按规范填写")
public class OrderItemController extends DefaultCrudController<OrderItemVO, OrderItemQuery, OrderItemReq, OrderItemUpdateReq, OrderItemService, OrderItemConvert> {
    @ApiOperation(value = "页面初始化操作")
    @PostMapping(value = "/initPage")
    public BusinessResponseVO initPage() {
        return super.initPage();
    }

    @ApiOperation(value = "查询表注释缺失,请按规范填写")
    @PostMapping(value = "/pageInfo")
    public PageResponseVO<OrderItemVO> pageInfo(@RequestBody @Validated OrderItemQuery query) {
        return super.pageInfo(query);
    }

    @ApiOperation(value = "新增时初始化操作")
    @PostMapping(value = "/initAdd/{orderItemId}")
    public BusinessResponseVO initAdd(@ApiParam(value = "主键", required = true) @PathVariable("orderItemId") BigInteger orderItemId) {
        return super.initAdd(orderItemId);
    }

    @ApiOperation(value = "修改时初始化操作")
    @PostMapping(value = "/initUpdate/{orderItemId}")
    public BusinessResponseVO initUpdate(@ApiParam(value = "主键", required = true) @PathVariable("orderItemId") BigInteger orderItemId) {
        return super.initUpdate(orderItemId);
    }

    @ApiOperation(value = "新增表注释缺失,请按规范填写")
    @PostMapping(value = "/add")
    public ResponseVO add(@RequestBody @Validated OrderItemReq req) {
        super.add(req);
        return ResponseVO.SYS_SUCCESS;
    }

    @ApiOperation(value = "修改表注释缺失,请按规范填写")
    @PostMapping(value = "/update")
    public ResponseVO update(@RequestBody @Validated OrderItemUpdateReq req) {
        super.update(req);
        return ResponseVO.SYS_SUCCESS;
    }

    @ApiOperation(value = "删除表注释缺失,请按规范填写")
    @PostMapping(value = "/delete/{orderItemId}")
    public ResponseVO delete(@ApiParam(value = "主键", required = true) @PathVariable("orderItemId") BigInteger orderItemId) {
        super.delete(orderItemId);
        return ResponseVO.SYS_SUCCESS;
    }


}

