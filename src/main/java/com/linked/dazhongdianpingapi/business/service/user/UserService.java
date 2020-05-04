package com.linked.dazhongdianpingapi.business.service.user;

import com.linked.dazhongdianpingapi.business.dao.UserDao;
import com.linked.dazhongdianpingapi.business.pojo.po.User;
import com.linked.dazhongdianpingapi.system.base.ErrorCode;
import com.linked.dazhongdianpingapi.system.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


/**
 * @author Linked
 * @date 2020/5/4 17:00
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Integer register(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("telephone", user.getTelephone());
        User checkUser = userDao.selectOneByExample(example);
        if (checkUser != null) {
            throw new ServiceException(ErrorCode.CUSTOM_WRONG, "号码已被注册");
        }
        return userDao.insertSelective(user);
    }


}
