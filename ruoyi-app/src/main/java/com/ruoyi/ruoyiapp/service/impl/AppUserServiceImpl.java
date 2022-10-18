package com.ruoyi.ruoyiapp.service.impl;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.ruoyiapp.constant.OrgCodeEnum;
import com.ruoyi.ruoyiapp.constant.ScanResultEnum;
import com.ruoyi.ruoyiapp.entity.AppScanRecordEntity;
import com.ruoyi.ruoyiapp.entity.AppUserEntity;
import com.ruoyi.ruoyiapp.mapper.AppUserMapper;
import com.ruoyi.ruoyiapp.request.UserRequestVo;
import com.ruoyi.ruoyiapp.response.UserMatchResponseVo;
import com.ruoyi.ruoyiapp.response.UserResponseListVo;
import com.ruoyi.ruoyiapp.response.UserResponseVo;
import com.ruoyi.ruoyiapp.service.AppScanRecordService;
import com.ruoyi.ruoyiapp.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
    public UserMatchResponseVo matchAndSave(UserRequestVo userRequestVo) {
        UserMatchResponseVo userMatchResponseVo =new UserMatchResponseVo();
        AppUserEntity appUserEntity = appUserMapper.queryforCondition(userRequestVo.getName(), userRequestVo.getIdNo());
        if (appUserEntity != null) {
            BeanUtils.copyProperties(appUserEntity,userMatchResponseVo);
            userMatchResponseVo.setResultCode(ScanResultEnum.PASS.getCode());
            //查询该用户今日扫码次数
            int count = timesLimit(userRequestVo.getIdNo());
            //扫描次数开关
            if (scanEnabled) {
                if (count >= timesLimit) {
                    userMatchResponseVo.setResultCode(ScanResultEnum.OVER_LIMIT.getCode());
                }
            }
            AppScanRecordEntity appScanRecordEntity = new AppScanRecordEntity();
            appScanRecordEntity.setUserId(userRequestVo.getIdNo());
            appScanRecordEntity.setScannedDate(new Date());
            appScanRecordEntity.setCreatedDate(new Date());
            appScanRecordEntity.setOrgCode(userRequestVo.getOrgCode());
            appScanRecordService.save(appScanRecordEntity);
            return userMatchResponseVo;
        } else {
            //TODO 用户不存在，保存到新建的表中
            userMatchResponseVo.setResultCode(ScanResultEnum.FAILED.getCode());
            return userMatchResponseVo;
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
        List<AppUserEntity> appUserEntities = appUserMapper.userList(pageIndex, pageSize);
        return appUserEntities;
    }

    @Override
    public UserResponseListVo queryUserList(int currentPage, int pageSize) {
        //获取登录用户信息
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysDept dept = loginUser.getUser().getDept();
        String orgCode ="";
        UserResponseListVo responseListVo = new UserResponseListVo();
        int pageIndex = (currentPage-1) * pageSize;
        if (StringUtils.isNotBlank(dept.getDeptName())){
            if (dept.getDeptName().equals(OrgCodeEnum.JMD.getName())){
                orgCode =OrgCodeEnum.JMD.getCode();
            }
            if (dept.getDeptName().equals(OrgCodeEnum.DJ.getName())){
                orgCode =OrgCodeEnum.DJ.getCode();
            }
            if (dept.getDeptName().equals(OrgCodeEnum.CJ.getName())){
                orgCode =OrgCodeEnum.CJ.getCode();
            }
            if (dept.getDeptName().equals(OrgCodeEnum.HH.getName())){
                orgCode =OrgCodeEnum.HH.getCode();
            }
            if (dept.getDeptName().equals(OrgCodeEnum.PT.getName())){
                orgCode =OrgCodeEnum.PT.getCode();
            }
        }

        List<UserResponseVo> userResponseVos = appUserMapper.queryUserList(pageIndex, pageSize, orgCode);
        for (UserResponseVo userResponseVo : userResponseVos) {
            if (StringUtils.isNotBlank(userResponseVo.getOrgCode())){
                if (userResponseVo.getOrgCode().equals(OrgCodeEnum.JMD.getCode())){
                    userResponseVo.setOrgCode(OrgCodeEnum.JMD.getName());
                }
                if (userResponseVo.getOrgCode().equals(OrgCodeEnum.DJ.getCode())){
                    userResponseVo.setOrgCode(OrgCodeEnum.DJ.getName());
                }
                if (userResponseVo.getOrgCode().equals(OrgCodeEnum.CJ.getCode())){
                    userResponseVo.setOrgCode(OrgCodeEnum.CJ.getName());
                }
                if (userResponseVo.getOrgCode().equals(OrgCodeEnum.HH.getCode())){
                    userResponseVo.setOrgCode(OrgCodeEnum.HH.getName());
                }
                if (userResponseVo.getOrgCode().equals(OrgCodeEnum.PT.getCode())){
                    userResponseVo.setOrgCode(OrgCodeEnum.PT.getName());
                }
            }
        }
        responseListVo.setUserResponseVoList(userResponseVos);
        responseListVo.setTotal(appUserMapper.count());
        return responseListVo;
    }


    @Override
    public List<UserResponseVo> selectUserList(UserRequestVo userRequestVo) {
        userRequestVo.setPageIndex((userRequestVo.getPageIndex() -1) * userRequestVo.getPageSize());
        return appUserMapper.selectUserList(userRequestVo);
    }
}
