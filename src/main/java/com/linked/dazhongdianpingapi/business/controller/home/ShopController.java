package com.linked.dazhongdianpingapi.business.controller.home;

import com.linked.dazhongdianpingapi.business.pojo.po.Shop;
import com.linked.dazhongdianpingapi.business.service.shop.ShopService;
import com.linked.dazhongdianpingapi.system.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lin
 * @date 2020/1/8 16:48
 */
@Api("商店数据")
@RestController
@RequestMapping("/shop")
public class ShopController {


    @Autowired
    private ShopService shopService;

    @PostMapping("list")
    @ApiOperation("获取商店列表")
    public ResultData<List<Shop>> getShopList() {
        return new ResultData<>(0, "获取成功", shopService.getShopList());
    }
}



