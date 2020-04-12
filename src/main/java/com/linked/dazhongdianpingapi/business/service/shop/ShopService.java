package com.linked.dazhongdianpingapi.business.service.shop;

import com.linked.dazhongdianpingapi.business.dao.CommentDao;
import com.linked.dazhongdianpingapi.business.dao.ShopDao;
import com.linked.dazhongdianpingapi.business.pojo.dto.ShopDetailDTO;
import com.linked.dazhongdianpingapi.business.pojo.po.Comment;
import com.linked.dazhongdianpingapi.business.pojo.po.Shop;
import com.linked.dazhongdianpingapi.business.pojo.vo.shop.ShopDetailVO;
import com.linked.dazhongdianpingapi.business.pojo.vo.shop.ShopListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Lin
 * @date 2020/1/8 16:44
 */
@Service
public class ShopService {

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private CommentDao commentDao;

    public List<Shop> getShopList(ShopListVO listVO) {
        return shopDao.getShopList(listVO);
    }

    public ShopDetailDTO getShopDetail(ShopDetailVO detailVO) {
        ShopDetailDTO detailDTO = new ShopDetailDTO();
        Shop shop = shopDao.selectByPrimaryKey(detailVO.getShopId());
        Example example = new Example(Comment.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("shopCommentedId", detailVO.getShopId());
        List<Comment> comments = commentDao.selectByExample(example);
        detailDTO.setComments(comments);
        detailDTO.setShop(shop);
        return detailDTO;
    }
}
