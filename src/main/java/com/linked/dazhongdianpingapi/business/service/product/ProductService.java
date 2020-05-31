package com.linked.dazhongdianpingapi.business.service.product;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.linked.dazhongdianpingapi.business.dao.ProductDao;
import com.linked.dazhongdianpingapi.business.pojo.dto.ProductDTO;
import com.linked.dazhongdianpingapi.business.pojo.po.Product;
import com.linked.dazhongdianpingapi.business.pojo.vo.product.ProductListVO;
import com.linked.dazhongdianpingapi.system.base.PageList;
import com.linked.dazhongdianpingapi.system.util.redis.RedisUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    private RedisUtil redisUtil;


    /**
     * 商品列表
     *
     * @param productListVO
     * @return
     */
    public List<Product> getProductList(ProductListVO productListVO) {

        if (redisUtil.get("PRODUCT_LIST_" + productListVO.getCategoryId()) != null) {
            return (List<Product>) redisUtil.get("PRODUCT_LIST_" + productListVO.getCategoryId());
        } else {
            Example example = new Example(Product.class);

            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("categoryId", productListVO.getCategoryId());
            List<Product> productList = productDao.selectByExample(example);
            redisUtil.set("PRODUCT_LIST_" + productListVO.getCategoryId(), productList);
            return productList;
        }
    }

    /**
     * 商品详情
     *
     * @param id
     * @return
     */
    public ProductDTO getProductDetail(Integer id) {
        ProductDTO productDTO = new ProductDTO();
        Product product;
        if (redisUtil.get("PRODUCT_DETAIL_" + id) != null) {
            product = (Product) redisUtil.get("PRODUCT_DETAIL_" + id);
        } else {
            product = productDao.selectByPrimaryKey(id);
            redisUtil.set("PRODUCT_DETAIL_" + id, product);
        }
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    /**
     * 抢购商品
     *
     * @return
     */

    public List<Product> getFlashSale() {
        if (redisUtil.get("PRODUCT_FLASH") != null) {
            return (List<Product>) redisUtil.get("PRODUCT_FLASH");
        } else {
            Example example = new Example(Product.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("isFlash", 1);
            List<Product> productList = productDao.selectByExample(example);
            redisUtil.set("PRODUCT_FLASH", productList);
            return productList;
        }
    }


}
