package com.ruoyi.ruoyiapp.service.impl;

import com.ruoyi.ruoyiapp.entity.AppScanRecordEntity;
import com.ruoyi.ruoyiapp.repository.AppScanRecordRepository;
import com.ruoyi.ruoyiapp.service.AppScanRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * 扫描记录service类
 *
 * @author guoxi_789@126.com
 * @date 2022/10/15
 */
@Service
@RequiredArgsConstructor
public class AppScanRecordServiceImpl implements AppScanRecordService {

    private final AppScanRecordRepository appScanRecordRepository;

    @Override
    public AppScanRecordEntity  save(AppScanRecordEntity appScanRecordEntity){
        return appScanRecordRepository.save(appScanRecordEntity);
    }
}
