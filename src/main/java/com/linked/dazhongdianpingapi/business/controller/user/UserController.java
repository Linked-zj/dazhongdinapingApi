package com.linked.dazhongdianpingapi.business.controller.user;

import com.linked.dazhongdianpingapi.business.pojo.dto.UserDTO;
import com.linked.dazhongdianpingapi.business.pojo.vo.user.UserEditVO;
import com.linked.dazhongdianpingapi.business.pojo.vo.user.UserLoginVO;
import com.linked.dazhongdianpingapi.business.pojo.vo.user.UserVO;
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
@Api("用户相关")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ApiOperation(value = "用户注册")
    public ResultData<UserDTO> doRegister(@RequestBody UserVO user) {
        return new ResultData<>(0, "注册成功", userService.register(user));
    }

    @PostMapping("edit")
    @ApiOperation(value = "用户编辑")
    public ResultData<Integer> doEdit(@RequestBody UserEditVO editVO) {
        return new ResultData<>(0, "编辑成功", userService.saveUser(editVO));
    }

    @PostMapping("login")
    @ApiOperation(value = "用户登录")
    public ResultData<UserDTO> doLogin(@RequestBody UserLoginVO loginVO) {
        return new ResultData<>(0, "登录成功", userService.sign(loginVO));
    }

    @PostMapping("signOut")
    @ApiOperation(value = "用户登出")
    public ResultData<Integer> signOut(){
        userService.signOut();
        return new ResultData<>(0,"登出成功");
    }


}
