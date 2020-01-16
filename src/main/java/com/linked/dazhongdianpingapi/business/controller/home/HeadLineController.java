package com.linked.dazhongdianpingapi.business.controller.home;

import com.linked.dazhongdianpingapi.business.pojo.po.HeadLine;
import com.linked.dazhongdianpingapi.business.service.headline.HeadLineService;
import com.linked.dazhongdianpingapi.system.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lin
 * @date 2019/12/27 14:59
 */
@Api("轮播图数据")
@RestController
@RequestMapping("/swipe")
public class HeadLineController {

    @Autowired
    private HeadLineService headLineService;

    @PostMapping("data")
    @ApiOperation("获取轮播图信息")
    public ResultData<List<HeadLine>> getHeadLine(){
        return new ResultData<>(0, "请求成功", headLineService.getHeadLineList());
    }

}
