package com.linked.dazhongdianpingapi.business.controller.order;

import com.linked.dazhongdianpingapi.business.pojo.dto.OrderDTO;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.HashVO;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.OrderListVO;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.OrderVO;
import com.linked.dazhongdianpingapi.business.service.order.OrderProductService;
import com.linked.dazhongdianpingapi.business.service.order.OrderService;
import com.linked.dazhongdianpingapi.system.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Linked
 * @date 2020/5/16 17:34
 */
@Api("订单相关")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderProductService orderProductService;

    @Autowired
    private OrderService orderService;

    @PostMapping("create")
    @ApiOperation(value = "用户下单")
    public ResultData<Integer> createOrder(@RequestBody OrderVO orderVO) {
        return new ResultData<>(0, "下单成功", orderProductService.insertOrderProduct(orderVO));
    }

    @PostMapping("list")
    @ApiOperation(value = "订单列表")
    public ResultData<List<OrderDTO>> createOrder(@RequestBody OrderListVO orderListVO) {
        return new ResultData<>(0, "下单成功", orderService.getOrderList(orderListVO));
    }

    @PostMapping("confirm/{id}")
    @ApiOperation(value = "确认收货")
    public ResultData<Integer> confirmOrder(@PathVariable("id") Integer id) {
        return new ResultData<>(0, "收货成功", orderService.saveOrder(id));
    }

    @PostMapping("get/hash")
    @ApiOperation(value = "获取hash码")
    public ResultData<String> getHash(@RequestBody HashVO hashVO) {
        return new ResultData<>(0, "获取成功", orderProductService.getVerifyHash(hashVO));
    }


}
