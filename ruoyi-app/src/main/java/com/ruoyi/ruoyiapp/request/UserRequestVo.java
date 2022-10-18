package com.ruoyi.ruoyiapp.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户提交信息
 *
 * @author guoxi_789@126.com
 * @date 2022/10/15
 */
@Data
public class UserRequestVo implements Serializable {
    /**姓名*/
    private String name;

    /**身份证号码*/
    private String idNo;

    /**性别*/
    private String sex;

    /**联系电话*/
    private String contactNumber;

    /**单位*/
    private String company;

    /**部门*/
    private String department;

    /**页面索引*/
    private int pageIndex;

    /**页面条数*/
    private int pageSize;

    /**检测机构*/
    private String orgCode;

}
