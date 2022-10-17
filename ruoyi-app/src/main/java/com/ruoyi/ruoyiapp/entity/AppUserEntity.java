package com.ruoyi.ruoyiapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * app_user
 * @author 
 */
@Table(name="app_user")
@Data
@Entity
public class AppUserEntity implements Serializable {
    /**
     * 主键UUID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 联系电话
     */
    private String contactNumber;

    /**
     * 身份证号码
     */
    private String idNo;

    /**
     * 单位名称
     */
    private String company;

    /**
     * 隶属行业主管部门
     */
    private String department;

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