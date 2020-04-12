package com.linked.dazhongdianpingapi.business.controller.home;

import com.linked.dazhongdianpingapi.business.pojo.dto.ShopDetailDTO;
import com.linked.dazhongdianpingapi.business.pojo.po.Shop;
import com.linked.dazhongdianpingapi.business.pojo.vo.shop.ShopDetailVO;
import com.linked.dazhongdianpingapi.business.pojo.vo.shop.ShopListVO;
import com.linked.dazhongdianpingapi.business.service.shop.ShopService;
import com.linked.dazhongdianpingapi.system.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResultData<List<Shop>> getShopList(@RequestBody ShopListVO listVO) {
        return new ResultData<>(0, "获取成功", shopService.getShopList(listVO));
    }

    @PostMapping("detail")
    @ApiOperation("获取商店详情")
    public ResultData<ShopDetailDTO> getsShopDetail(@RequestBody ShopDetailVO detailVO) {
        return new ResultData<>(0, "获取成功", shopService.getShopDetail(detailVO));
    }

}



