package com.linked.dazhongdianpingapi.business.service.product;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.linked.dazhongdianpingapi.business.dao.ProductDao;
import com.linked.dazhongdianpingapi.business.pojo.po.Product;
import com.linked.dazhongdianpingapi.business.pojo.vo.ProductListVO;
import com.linked.dazhongdianpingapi.system.base.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Linked
 * @date 2020/3/14 21:50
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;


    /**
     * 商品列表
     * @param productListVO
     * @return
     */
    public PageList<Page> getProductList(ProductListVO productListVO) {
        Page page = PageHelper.startPage(productListVO.getPageNum(), productListVO.getPageSize());
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId", productListVO.getCategoryId());
        productDao.selectByExample(example);
        return new PageList<>(page);

    }

}
