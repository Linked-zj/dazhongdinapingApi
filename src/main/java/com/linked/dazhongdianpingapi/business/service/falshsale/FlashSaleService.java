package com.linked.dazhongdianpingapi.business.service.falshsale;

import com.linked.dazhongdianpingapi.business.dao.FlashSaleDao;
import com.linked.dazhongdianpingapi.business.pojo.po.FlashSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lin
 * @date 2020/1/3 15:10
 */
@Service
public class FlashSaleService {

    @Autowired
    private FlashSaleDao flashSaleDao;

    public List<FlashSale> getFlashSale(){
        return flashSaleDao.selectAll();
    }

}
