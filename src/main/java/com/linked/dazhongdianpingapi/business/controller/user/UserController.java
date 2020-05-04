package com.linked.dazhongdianpingapi.business.controller.user;

import com.linked.dazhongdianpingapi.business.pojo.dto.ProductDTO;
import com.linked.dazhongdianpingapi.business.pojo.po.User;
import com.linked.dazhongdianpingapi.business.service.user.UserService;
import com.linked.dazhongdianpingapi.system.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Linked
 * @date 2020/5/4 16:56
 */
@Api("轮播图数据")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ApiOperation(value = "用户注册")
    public ResultData<Integer> doRegister(@RequestBody User user) {
        return new ResultData<>(0, "注册成功", userService.register(user));
    }


}
