package com.ruoyi.ruoyiapp.mapper;

import com.ruoyi.ruoyiapp.entity.AppScanRecordEntity;
import org.apache.ibatis.annotations.Mapper;

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
}