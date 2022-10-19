package com.ruoyi.ruoyiapp.mapper;

import com.ruoyi.ruoyiapp.entity.AppScanRecordEntity;
import com.ruoyi.ruoyiapp.request.AppScanRecordRequestVo;
import com.ruoyi.ruoyiapp.response.AppScanRecordResponseVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 扫描记录
 *
 * @author guoxi_789@126.com
 * @date 2022/10/15
 */
@Mapper
public interface AppScanRecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AppScanRecordEntity record);

    int insertSelective(AppScanRecordEntity record);

    AppScanRecordEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppScanRecordEntity record);

    int updateByPrimaryKey(AppScanRecordEntity record);

    List<AppScanRecordResponseVo> queryScanList(AppScanRecordRequestVo appScanRecordRequestVo);

    /**
     * 功能描述 查询总条数
     * @author guoxi_789@126.com
     * @date 2022/10/17
     * @return 总条数
     */
    int count(AppScanRecordRequestVo userRequestVo);

    /**
    * 功能描述 扫码记录导出
    * @author guoxi_789@126.com
    * @date 2022/10/19
    * @param  appScanRecordRequestVo 参数
    * @return 扫码记录列表
    */
    List<AppScanRecordResponseVo> queryForExport(AppScanRecordRequestVo appScanRecordRequestVo);
}