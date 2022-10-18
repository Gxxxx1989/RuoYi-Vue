package com.ruoyi.ruoyiapp.mapper;

import com.ruoyi.ruoyiapp.entity.AppUserEntity ;
import com.ruoyi.ruoyiapp.request.UserRequestVo;
import com.ruoyi.ruoyiapp.response.UserResponseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AppUserEntity record);

    int insertSelective(AppUserEntity record);

    AppUserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppUserEntity record);

    int updateByPrimaryKey(AppUserEntity record);

    AppUserEntity queryIfExist(@Param("idNo") String idNo);

    AppUserEntity queryforCondition(@Param("name") String name,@Param("idNo") String idNo);

    /**
    * 功能描述 扫码次数
    * @author guoxi_789@126.com
    * @date 2022/10/17
    * @param  idNo 身份证号码
    * @return 扫码次数
    */
    int timesLimit(@Param("idNo") String idNo);

    /**
    * 功能描述 分页查询
    * @author guoxi_789@126.com
    * @date 2022/10/17
    * @param  pageIndex 开始
    * @param  pageSize 条数
    * @return 用户列表
    */
    List<AppUserEntity> userList(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    /**
    * 功能描述 查询下载信息
    * @author guoxi_789@126.com
    * @date 2022/10/17
    * @param  userRequestVo 参数
    * @return 用户列表
    */
    List<UserResponseVo> selectUserList(UserRequestVo userRequestVo);


    /**
    * 功能描述 分页查询页面列表
    * @author guoxi_789@126.com
    * @date 2022/10/17
    * @param  pageIndex 页面索引
    * @param  pageSize 页面条数
    * @param  orgCode 组织机构编码
    * @return 用户列表
    */
    List<UserResponseVo> queryUserList(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize,@Param("orgCode") String orgCode);

    /**
    * 功能描述 查询总条数
    * @author guoxi_789@126.com
    * @date 2022/10/17
    * @return 总条数
    */
    int count();


}