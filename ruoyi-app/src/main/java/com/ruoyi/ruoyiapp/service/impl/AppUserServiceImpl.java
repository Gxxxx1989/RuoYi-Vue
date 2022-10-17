package com.ruoyi.ruoyiapp.service.impl;

import com.ruoyi.ruoyiapp.constant.ScanResultEnum;
import com.ruoyi.ruoyiapp.entity.AppScanRecordEntity;
import com.ruoyi.ruoyiapp.entity.AppUserEntity;
import com.ruoyi.ruoyiapp.mapper.AppUserMapper;
import com.ruoyi.ruoyiapp.request.UserRequestVo;
import com.ruoyi.ruoyiapp.service.AppScanRecordService;
import com.ruoyi.ruoyiapp.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户service
 *
 * @author guoxi_789@126.com
 * @date 2022/10/15
 */
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserMapper appUserMapper;
    private final AppScanRecordService appScanRecordService;

    @Value(value = "${scan.timesLimit}")
    private int timesLimit;

    @Value(value = "${scan.scanEnabled}")
    private boolean scanEnabled;


    @Override
    public boolean queryIfExist(String idNo) {
        AppUserEntity appUserEntity = appUserMapper.queryIfExist(idNo);
        return appUserEntity != null;
    }

    @Override
    public String matchAndSave(UserRequestVo userRequestVo) {
        AppUserEntity appUserEntity = appUserMapper.queryforCondition(userRequestVo.getName(), userRequestVo.getIdNo());
        //该用户存在
        if (appUserEntity != null) {
            //查询该用户今日扫码次数
            int count = timesLimit(userRequestVo.getIdNo());
            //扫描次数开关
            if (scanEnabled) {
                if (count >= timesLimit) {
                    return ScanResultEnum.OVER_LIMIT.getCode();
                }
            }
            AppScanRecordEntity appScanRecordEntity = new AppScanRecordEntity();
            appScanRecordEntity.setUserId(userRequestVo.getIdNo());
            appScanRecordEntity.setScannedDate(new Date());
            appScanRecordEntity.setCreatedDate(new Date());
            appScanRecordService.save(appScanRecordEntity);
            return ScanResultEnum.PASS.getCode();
        } else {
            //TODO 用户不存在，保存到新建的表中
            return ScanResultEnum.FAILED.getCode();
        }
    }

    @Override
    public AppUserEntity userInfo(UserRequestVo userRequestVo) {
        return appUserMapper.queryIfExist(userRequestVo.getIdNo());
    }


    @Override
    public int timesLimit(String idNo) {
        return appUserMapper.timesLimit(idNo);
    }

    @Override
    public List<AppUserEntity> userList(int currentPage, int pageSize) {
        int pageIndex = (currentPage-1) * pageSize;
        return appUserMapper.userList(pageIndex, pageSize);
    }
}
