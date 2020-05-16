package com.linked.dazhongdianpingapi.business.service.order;

import com.linked.dazhongdianpingapi.business.dao.OrderProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Linked
 * @date 2020/5/11 17:46
 */
@Slf4j
@Service
public class OrderProductService {


    @Autowired
    private OrderProductDao orderProductDao;



}
