package com.ruoyi.ruoyiapp.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.util.Date;

@Data
public class AppScanRecordResponseVo {
    /**
     * 主键UUID
     */
    private Integer id;

    /**
     * u_user表主键id
     */
    private String userId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    private String contactNumber;

    /**
     * 联系电话
     */
    @Excel(name = "部门")
    private String department;

    /**
     * 扫码日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date scannedDate;


    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdDate;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    /**
     * 更新人
     */
    private String updatedBy;


    /**
     * 更新人
     */
    private String orgCode;

    private static final long serialVersionUID = 1L;
}
