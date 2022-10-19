package com.ruoyi.ruoyiapp.service.impl;

import com.ruoyi.ruoyiapp.constant.OrgCodeEnum;
import com.ruoyi.ruoyiapp.entity.AppScanRecordEntity;
import com.ruoyi.ruoyiapp.mapper.AppScanRecordMapper;
import com.ruoyi.ruoyiapp.repository.AppScanRecordRepository;
import com.ruoyi.ruoyiapp.request.AppScanRecordRequestVo;
import com.ruoyi.ruoyiapp.response.AppScanRecordResponseListVo;
import com.ruoyi.ruoyiapp.response.AppScanRecordResponseVo;
import com.ruoyi.ruoyiapp.service.AppScanRecordService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;


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
    private final AppScanRecordMapper appScanRecordMapper;

    @Override
    public AppScanRecordEntity save(AppScanRecordEntity appScanRecordEntity) {
        return appScanRecordRepository.save(appScanRecordEntity);
    }

    @Override
    public AppScanRecordResponseListVo queryScanList(AppScanRecordRequestVo appScanRecordRequestVo) {
        AppScanRecordResponseListVo appScanRecordResponseListVo = new AppScanRecordResponseListVo();
        appScanRecordRequestVo.setPageIndex((appScanRecordRequestVo.getPageIndex() -1) * appScanRecordRequestVo.getPageSize());
        List<AppScanRecordResponseVo> appScanRecordResponseVos = appScanRecordMapper.queryScanList(appScanRecordRequestVo);
        appScanRecordResponseListVo.setAppScanRecordResponseVos(appScanRecordResponseVos);
        appScanRecordResponseListVo.setTotal(appScanRecordMapper.count(appScanRecordRequestVo));

        for (AppScanRecordResponseVo appScanRecordResponseVo : appScanRecordResponseVos) {
            if (StringUtils.isNotBlank(appScanRecordResponseVo.getOrgCode())){
                if (appScanRecordResponseVo.getOrgCode().equals(OrgCodeEnum.JMD.getCode())){
                    appScanRecordResponseVo.setOrgCode(OrgCodeEnum.JMD.getName());
                }
                if (appScanRecordResponseVo.getOrgCode().equals(OrgCodeEnum.DJ.getCode())){
                    appScanRecordResponseVo.setOrgCode(OrgCodeEnum.DJ.getName());
                }
                if (appScanRecordResponseVo.getOrgCode().equals(OrgCodeEnum.CJ.getCode())){
                    appScanRecordResponseVo.setOrgCode(OrgCodeEnum.CJ.getName());
                }
                if (appScanRecordResponseVo.getOrgCode().equals(OrgCodeEnum.HH.getCode())){
                    appScanRecordResponseVo.setOrgCode(OrgCodeEnum.HH.getName());
                }
                if (appScanRecordResponseVo.getOrgCode().equals(OrgCodeEnum.PT.getCode())){
                    appScanRecordResponseVo.setOrgCode(OrgCodeEnum.PT.getName());
                }
            }
        }
        return appScanRecordResponseListVo;
    }
}
