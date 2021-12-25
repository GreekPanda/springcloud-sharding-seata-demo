package com.zhqc.cloud.sharding.controller;

import com.zhqc.cloud.sharding.model.po.OrderPOExt;
import com.zhqc.cloud.sharding.model.req.OrderReq;
import com.zhqc.cloud.sharding.model.req.OrderReqExt;
import com.zhqc.cloud.sharding.service.OrderService;
import com.zhqc.framerwork.common.model.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author liaoh
 * @version 1.0
 * @date 2021/12/23 16:55
 */
@RestController
@RequestMapping("/remote/order")
@Api(value = "表注释缺失,请按规范填写")
public class OrderRemoteController {

    @Lazy
    @Resource
    private OrderService orderService;

    @ApiOperation(value = "新增表注释缺失,请按规范填写")
    @PostMapping(value = "/add")
    public ResponseVO add(@RequestBody @Validated OrderReqExt req) {
        int ret = orderService.addWithItem(req);
        if (ret != 0) {
            return ResponseVO.success();
        } else {
            return ResponseVO.buildResponseVO(500, "failure");
        }
    }
}
