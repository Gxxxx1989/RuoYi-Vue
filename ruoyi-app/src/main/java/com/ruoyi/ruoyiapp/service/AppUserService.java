package com.ruoyi.ruoyiapp.service;

import com.ruoyi.ruoyiapp.entity.AppUserEntity;
import com.ruoyi.ruoyiapp.request.UserRequestVo;

import java.util.List;

/**
 * 用户信息实体类
 *
 * @author guoxi_789@126.com
 * @date 2022/10/17
 */
public interface AppUserService {
    /**
    * 功能描述 根据身份证号码查询用户是否存在
    * @author guoxi_789@126.com
    * @date 2022/10/17
    * @param  idNo 身份证号码
    * @return 是否存在
    */
    boolean queryIfExist(String idNo);

    /**
    * 功能描述 查询用户匹配信息报保存扫码记录
    * @author guoxi_789@126.com
    * @date 2022/10/17
    * @param  userRequestVo 参数
    * @return 返回状态码
    */
    String matchAndSave(UserRequestVo userRequestVo);

    /**
    * 功能描述 查询单个用户信息
    * @author guoxi_789@126.com
    * @date 2022/10/17
    * @param  userRequestVo 参数
    * @return 单个用户信息
    */
    AppUserEntity userInfo(UserRequestVo userRequestVo);

    /**
    * 功能描述 免费用户今日扫码次数
    * @author guoxi_789@126.com
    * @date 2022/10/16
    * @param  idNo 身份证号码
    * @return 次数
    */
    int timesLimit(String idNo);

    /**
    * 功能描述 查询用户列表
    * @author guoxi_789@126.com
    * @date 2022/10/17
    * @param currentPage 当前页
    * @param pageSize 条数
    * @return 用户列表
    */
    List<AppUserEntity> userList(int currentPage, int pageSize);


}
