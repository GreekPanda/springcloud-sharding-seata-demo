package com.zhqc.cloud.sharding.order;

import com.zhqc.cloud.sharding.bean.OrderBeanDTO;
import com.zhqc.cloud.sharding.handler.order.ShardingSeataFeignApiWithSentinelFallbackFactory;
import com.zhqc.cloud.sharding.model.dto.sharding.OrderReqDTO;
import com.zhqc.framerwork.common.model.vo.BusinessResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TODO
 *
 * @author liaoh
 * @version 1.0
 * @date 2021/12/23 10:12
 */
@FeignClient(name = "${feign.client.sharding.name}", fallbackFactory = ShardingSeataFeignApiWithSentinelFallbackFactory.class)
public interface ShardingSeataFeignApi {
    @PostMapping("/sharding/order/addWithItem")
    @ApiOperation(value = "添加订单和明细")
    BusinessResponseVO<OrderBeanDTO> addWithItem(@Validated @RequestBody OrderReqDTO request);
}
