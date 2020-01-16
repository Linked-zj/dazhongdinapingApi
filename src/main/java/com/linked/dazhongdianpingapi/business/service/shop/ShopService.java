package com.linked.dazhongdianpingapi.business.service.shop;

import com.linked.dazhongdianpingapi.business.dao.ShopDao;
import com.linked.dazhongdianpingapi.business.pojo.po.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lin
 * @date 2020/1/8 16:44
 */
@Service
public class ShopService {

    @Autowired
    private ShopDao shopDao;

    public List<Shop> getShopList() {
        return shopDao.selectAll();
    }
}
