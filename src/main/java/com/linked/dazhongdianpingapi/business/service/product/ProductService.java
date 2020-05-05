package com.linked.dazhongdianpingapi.business.service.product;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.linked.dazhongdianpingapi.business.dao.ProductDao;
import com.linked.dazhongdianpingapi.business.pojo.dto.ProductDTO;
import com.linked.dazhongdianpingapi.business.pojo.po.Product;
import com.linked.dazhongdianpingapi.business.pojo.vo.product.ProductListVO;
import com.linked.dazhongdianpingapi.system.base.PageList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


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
     *
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

    /**
     * 商品详情
     * @param id
     * @return
     */
    public ProductDTO getProductDetail(Integer id) {
        ProductDTO productDTO = new ProductDTO();
        Product product = productDao.selectByPrimaryKey(id);
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

}
