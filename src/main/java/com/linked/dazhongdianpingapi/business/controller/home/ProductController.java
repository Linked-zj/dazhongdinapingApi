package com.linked.dazhongdianpingapi.business.controller.home;

import com.linked.dazhongdianpingapi.business.pojo.dto.ProductDTO;
import com.linked.dazhongdianpingapi.business.pojo.po.Product;
import com.linked.dazhongdianpingapi.business.pojo.vo.product.ProductListVO;
import com.linked.dazhongdianpingapi.business.service.product.ProductService;
import com.linked.dazhongdianpingapi.system.base.PageList;
import com.linked.dazhongdianpingapi.system.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResultData<List<Product>> getProductList(@RequestBody ProductListVO productListVO) {
        return new ResultData<>(0, "获取成功", productService.getProductList(productListVO));
    }

    @PostMapping("detail/{id}")
    @ApiOperation(value = "获取商品详情")
    public ResultData<ProductDTO> getProductDetail(@PathVariable("id") Integer id) {
        return new ResultData<>(0, "获取成功", productService.getProductDetail(id));
    }

    @PostMapping("flash")
    @ApiOperation(value = "抢购商品")
    public ResultData<List<Product>> getFlashList() {
        return new ResultData<>(0, "获取成功", productService.getFlashSale());
    }
}
