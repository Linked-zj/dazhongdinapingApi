package com.linked.dazhongdianpingapi.business.service.headline;

import com.linked.dazhongdianpingapi.business.dao.HeadLineDao;
import com.linked.dazhongdianpingapi.business.pojo.po.HeadLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lin
 * @date 2019/12/27 14:51
 */
@Service
public class HeadLineService {
    @Autowired
    private HeadLineDao headLineDao;

    public List<HeadLine> getHeadLineList() {
        return headLineDao.selectAll();
    }
}
