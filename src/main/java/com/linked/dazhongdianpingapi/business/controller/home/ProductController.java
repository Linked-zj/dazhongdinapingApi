package com.linked.dazhongdianpingapi.business.controller.home;

import com.linked.dazhongdianpingapi.business.pojo.vo.ProductListVO;
import com.linked.dazhongdianpingapi.business.service.product.ProductService;
import com.linked.dazhongdianpingapi.business.service.shop.ShopService;
import com.linked.dazhongdianpingapi.system.base.PageList;
import com.linked.dazhongdianpingapi.system.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Linked
 * @date 2020/3/14 22:01
 */
@Api("商品数据")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("list")
    @ApiOperation(value = "商品列表")
    public ResultData<PageList> getProductList(@RequestBody ProductListVO productListVO) {
        return new ResultData<>(0, "获取成功", productService.getProductList(productListVO));
    }
}
