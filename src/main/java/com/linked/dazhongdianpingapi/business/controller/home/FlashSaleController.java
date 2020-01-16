package com.linked.dazhongdianpingapi.business.controller.home;

import com.linked.dazhongdianpingapi.business.pojo.po.FlashSale;
import com.linked.dazhongdianpingapi.business.service.falshsale.FlashSaleService;
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
 * @date 2020/1/3 15:20
 */

@Api("限时抢购数据")
@RestController
@RequestMapping("/flash")
public class FlashSaleController {

    @Autowired
    private FlashSaleService flashSaleService;

    @PostMapping("/data")
    @ApiOperation("获取秒杀商品")
    public ResultData<List<FlashSale>> getFlashSale() {
       return  new ResultData<>(0,"请求成功",flashSaleService.getFlashSale());
    }

}


