package com.ruoyi.ruoyiapp.service;

import com.ruoyi.ruoyiapp.entity.AppScanRecordEntity;
import com.ruoyi.ruoyiapp.request.AppScanRecordRequestVo;
import com.ruoyi.ruoyiapp.response.AppScanRecordResponseListVo;

import java.util.List;

/**
 * 扫描记录service
 *
 * @author guoxi_789@126.com
 * @date 2022/10/15
 */
public interface AppScanRecordService {
    /**
    * 功能描述
    * @author guoxi_789@126.com
    * @date 2022/10/15
    * @param  appScanRecordEntity 参数
    * @return 保存扫描纪录
    */
    AppScanRecordEntity save(AppScanRecordEntity appScanRecordEntity);

    /**
    * 功能描述 查询扫描详情
    * @author guoxi_789@126.com
    * @date 2022/10/19
    * @param  appScanRecordRequestVo 查询参数
    * @return 返回扫描列表
    */
    AppScanRecordResponseListVo queryScanList(AppScanRecordRequestVo appScanRecordRequestVo);
}
