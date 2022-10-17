package com.ruoyi.ruoyiapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * app_scan_record
 * @author 
 */
@Table(name="app_scan_record")
@Data
@Entity
public class AppScanRecordEntity implements Serializable {
    /**
     * 主键UUID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * u_user表主键id
     */
    private String userId;

    /**
     * 扫码日期
     */
    private Date scannedDate;

    /**
     * 创建日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createdDate;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDate;

    /**
     * 更新人
     */
    private String updatedBy;

    private static final long serialVersionUID = 1L;
}