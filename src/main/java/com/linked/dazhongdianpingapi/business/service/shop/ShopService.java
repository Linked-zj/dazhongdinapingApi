package com.linked.dazhongdianpingapi.business.service.shop;

import com.linked.dazhongdianpingapi.business.dao.CommentDao;
import com.linked.dazhongdianpingapi.business.dao.ShopDao;
import com.linked.dazhongdianpingapi.business.dao.ShopProductDao;
import com.linked.dazhongdianpingapi.business.pojo.dto.ShopDetailDTO;
import com.linked.dazhongdianpingapi.business.pojo.po.Comment;
import com.linked.dazhongdianpingapi.business.pojo.po.Shop;
import com.linked.dazhongdianpingapi.business.pojo.po.ShopProduct;
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

    @Autowired
    private ShopProductDao shopProductDao;

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

        Example shopExample = new Example(ShopProduct.class);
        Example.Criteria shopCriteria = shopExample.createCriteria();
        shopCriteria.andEqualTo("shopId", shop.getId());
        List<ShopProduct> shopProducts = shopProductDao.selectByExample(shopExample);

        detailDTO.setComments(comments);
        detailDTO.setShopProductsList(shopProducts);
        detailDTO.setShop(shop);
        return detailDTO;
    }
}
