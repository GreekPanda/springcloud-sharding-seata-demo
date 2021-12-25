package com.zhqc.cloud.sharding.handler.order;

import com.zhqc.cloud.sharding.bean.OrderBeanDTO;
import com.zhqc.cloud.sharding.model.dto.sharding.OrderReqDTO;
import com.zhqc.cloud.sharding.order.ShardingSeataFeignApi;
import com.zhqc.framerwork.common.model.vo.BusinessResponseVO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author liaoh
 * @version 1.0
 * @date 2021/12/23 10:13
 */
@Component
@Slf4j
public class ShardingSeataFeignApiWithSentinelFallbackFactory implements FallbackFactory<ShardingSeataFeignApi> {
    @Override
    public ShardingSeataFeignApi create(Throwable throwable) {
        return new ShardingSeataFeignApi() {
            @Override
            public BusinessResponseVO<OrderBeanDTO> addWithItem(OrderReqDTO request) {
                log.error("addWithItem case some error {}", request.getOrderId(), throwable);
                return BusinessResponseVO.buildFailVo("failure");
            }
        };
    }
}
