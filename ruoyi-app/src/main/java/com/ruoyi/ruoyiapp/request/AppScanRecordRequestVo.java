package com.ruoyi.ruoyiapp.request;

import lombok.Data;

import java.util.Date;

/**
 * 请求参数
 *
 * @author guoxi_789@126.com
 * @date 2022/10/19
 */
@Data
public class AppScanRecordRequestVo {

    /**
     * 用户名
     */
    private String  name;

    /**
     * 联系电话
     */
    private String contactNumber;

    /**
     * 身份证号码
     */
    private String userId;

    /**
     * 扫码日期开始
     */
    private Date scannedDateStart;

    /**
     * 扫码日期结束
     */
    private Date scannedDateEnd;

    /**
     * 页面索引
     */
    private int pageIndex;

    /**
     * 页面条数
     */
    private int pageSize;

    /**
     * 检测机构
     */
    private String orgCode;
}
