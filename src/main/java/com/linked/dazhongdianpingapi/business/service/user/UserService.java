package com.linked.dazhongdianpingapi.business.service.user;

import com.linked.dazhongdianpingapi.business.dao.UserDao;
import com.linked.dazhongdianpingapi.business.pojo.dto.UserDTO;
import com.linked.dazhongdianpingapi.business.pojo.dto.UserLoginDTO;
import com.linked.dazhongdianpingapi.business.pojo.po.User;
import com.linked.dazhongdianpingapi.business.pojo.vo.user.UserEditVO;
import com.linked.dazhongdianpingapi.business.pojo.vo.user.UserLoginVO;
import com.linked.dazhongdianpingapi.system.base.ErrorCode;
import com.linked.dazhongdianpingapi.system.base.SystemConfig;
import com.linked.dazhongdianpingapi.system.exception.ServiceException;
import com.linked.dazhongdianpingapi.system.util.codec.MD5;
import com.linked.dazhongdianpingapi.system.util.jwt.JWTUtil;
import com.linked.dazhongdianpingapi.system.util.redis.RedisUtil;
import com.linked.dazhongdianpingapi.system.util.threadlocal.ThreadLocalManager;
import com.linked.dazhongdianpingapi.system.util.threadlocal.TokenContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;


/**
 * @author Linked
 * @date 2020/5/4 17:00
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtil redisUtil;

    public UserDTO register(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("telephone", user.getTelephone());
        User checkUser = userDao.selectOneByExample(example);
        if (checkUser != null) {
            throw new ServiceException(ErrorCode.CUSTOM_WRONG, "号码已被注册");
        }
        user.setPassword(MD5.encode(user.getPassword()));
        user.setCreateTime(new Date());
        userDao.insertSelective(user);
        return loginWithToken(user.getId(), 1);
    }

    /**
     * 保存至redis与ThreadLocal中
     * @param userId
     * @param loginType
     * @return
     */
    public UserDTO loginWithToken(Integer userId, Integer loginType) {
        UserDTO userDTO = new UserDTO();
        TokenContext tokenContext = new TokenContext();
        tokenContext.setUserId(userId);
        tokenContext.setType(loginType);
        tokenContext.setCreateTime(System.currentTimeMillis());
        String securityToken = JWTUtil.createToken();
        tokenContext.setToken(securityToken);
        ThreadLocalManager.setTokenContext(tokenContext);
        redisUtil.set(securityToken, tokenContext, SystemConfig.REDIS_DELETE_TOKEN_TIME);
        userDTO.setToken(securityToken);
        userDTO.setUserId(userId);
        return userDTO;
    }

    /**
     * 用户登录
     * @param param
     * @return
     */
    public UserDTO sign(UserLoginVO param) {
        //1.加密密码
        param.setPassword(MD5.encode(param.getPassword()));
        //2.判断用户是否存在且密码是否正确
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("telephone", param.getLoginName());
        criteria.andEqualTo("password", param.getPassword());
        User loginUser = userDao.selectOneByExample(example);
        if (loginUser != null) {
            return loginWithToken(loginUser.getId(),SystemConfig.LOGIN_WEB);
        }else {
            throw new ServiceException(ErrorCode.CUSTOM_WRONG, "用户不存在");
        }
    }



    /**
     * 用户编辑
     * @param editVO
     * @return
     */
    public Integer saveUser(UserEditVO editVO) {
        User user = new User();
        BeanUtils.copyProperties(editVO, user);
        System.out.println(new ThreadLocalManager());
        System.out.println(ThreadLocalManager.getTokenContext().toString());
        user.setId(ThreadLocalManager.getTokenContext().getUserId());
        return userDao.updateByPrimaryKeySelective(user);
    }

    public void signOut() {
        // 从当前线程中获取用户信息
        TokenContext tokenContext = ThreadLocalManager.getTokenContext();
        //从redis中删除用户信息
        redisUtil.remove(tokenContext.getToken());
    }

}
