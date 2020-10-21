package com.zh.springcloud.service.impl;

import com.zh.springcloud.dao.StorageDao;
import com.zh.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 卓少武
 * @date 2020/10/20
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);

    }
}
