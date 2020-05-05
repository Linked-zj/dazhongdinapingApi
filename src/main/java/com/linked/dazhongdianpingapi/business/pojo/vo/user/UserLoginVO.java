package com.linked.dazhongdianpingapi.business.pojo.vo.user;

import lombok.Data;

/**
 * @author Linked
 * @date 2020/5/5 15:04
 */
@Data
public class UserLoginVO {

    /**
     * 手机或者邮箱或者用户名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;


}
