package com.zhqc.cloud.sharding;

import com.alibaba.fastjson.JSON;
import com.zhqc.cloud.sharding.model.po.OrderItemPO;
import com.zhqc.cloud.sharding.model.po.OrderPO;
import com.zhqc.cloud.sharding.model.po.OrderPOExample;
import com.zhqc.cloud.sharding.model.po.OrderPOExt;
import com.zhqc.cloud.sharding.model.query.OrderQuery;
import com.zhqc.cloud.sharding.model.req.OrderItemReq;
import com.zhqc.cloud.sharding.model.req.OrderReq;
import com.zhqc.cloud.sharding.model.req.OrderUpdateReq;
import com.zhqc.cloud.sharding.service.OrderItemService;
import com.zhqc.cloud.sharding.service.OrderService;
import com.zhqc.framerwork.common.model.req.EditReq;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * TODO
 *
 * @author liaoh
 * @version 1.0
 * @date 2021/12/21 20:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestShardingData {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;


    @Test
    public void insertData() throws InterruptedException {
        for(int i = 0; i < 1000; i++) {
            OrderReq orderReq = new OrderReq();
            orderReq.setOrderNo(UUID.randomUUID().toString().replace("-", ""));
            orderReq.setUserId(BigInteger.valueOf(i));
            orderService.add(orderReq);
            Thread.sleep(100);
        }
    }

    @Test
    public void queryData() {
        OrderPOExample orderPOExample = new OrderPOExample();
        orderPOExample.createCriteria().andUserIdEqualTo(BigInteger.valueOf(1));
        OrderQuery orderQuery = new OrderQuery();
        Long orderId = 680170119598944256L;
        orderQuery.setOrderId(orderId);
        //orderQuery.setUserId(BigInteger.valueOf(10));
        List<OrderPO> orderPOList = orderService.queryList(orderQuery);
        log.info(JSON.toJSONString(orderPOList));
    }

    @Test
    public void delData() {
        OrderPOExample orderPOExample = new OrderPOExample();
        orderPOExample.createCriteria().andUserIdEqualTo(BigInteger.valueOf(1));
        OrderQuery orderQuery = new OrderQuery();
        Long orderId = 680170117019447296L;
        orderQuery.setOrderId(orderId);
        orderService.delete(BigInteger.valueOf(orderId));

    }

    @Test
    public void updateDate() {
        OrderUpdateReq orderUpdateReq = new OrderUpdateReq();
        Long orderId = 680170119598944256L;
        orderUpdateReq.setOrderId(BigInteger.valueOf(orderId));
        orderUpdateReq.setId(BigInteger.valueOf(orderId));
        orderUpdateReq.setOrderNo("123456789");
        orderUpdateReq.setUserId(BigInteger.valueOf(123456789));
        orderService.updateAll(orderUpdateReq);
    }

    @Test
    @SneakyThrows
    public void insertComplexData() {
        for(int i = 0; i < 100; i++) {
            OrderReq orderReq = new OrderReq();
            orderReq.setOrderNo(UUID.randomUUID().toString().replace("-", ""));
            orderReq.setUserId(BigInteger.valueOf(i));
            OrderPO orderPO = orderService.add(orderReq);
            if(orderPO != null) {
                for(int j = 0; j < 5; j++) {
                    OrderItemReq orderItemReq = new OrderItemReq();
                    orderItemReq.setOrderId(orderPO.getId());
                    orderItemReq.setItemName("name-" + j + "-" + UUID.randomUUID().toString().replace("-", ""));
                    orderItemReq.setUserId(orderPO.getUserId());
                    orderItemService.add(orderItemReq);
                }
            }
            Thread.sleep(10);
        }
    }

    @Test
    public void updateComplexData() {
        //对于分片键无法做更新
        //TODO 需要再研究和实践
    }

    @Test
    public void queryComplexData() {
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setUserId(BigInteger.valueOf(10));
        List<OrderPOExt> orderPOExtList = orderService.selectByUserId(orderQuery);
        log.info("Query complex data: {}", JSON.toJSONString(orderPOExtList));
    }
}
