package com.ruoyi.web.controller.app;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.ruoyiapp.entity.AppUserEntity;
import com.ruoyi.ruoyiapp.request.AppScanRecordRequestVo;
import com.ruoyi.ruoyiapp.request.UserRequestVo;
import com.ruoyi.ruoyiapp.response.UserResponseVo;
import com.ruoyi.ruoyiapp.service.AppScanRecordService;
import com.ruoyi.ruoyiapp.service.AppUserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author guoxi
 */
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final AppUserService appUserService;
    private final AppScanRecordService appScanRecordService;

    @PostMapping(value = "/match")
    @ApiOperation("查询数据库是否存在该身份信息")
    public AjaxResult queryInDb(String  idNo){
        return AjaxResult.success(appUserService.queryIfExist(idNo));
    }

    @PostMapping(value = "/matchAndSave")
    @ApiOperation("查询数据库是否存在该身份信息并保存扫码记录")
    public AjaxResult queryInDb(@RequestBody UserRequestVo userRequestVo){
        return AjaxResult.success(appUserService.matchAndSave(userRequestVo));
    }

    @PostMapping(value = "/userInfo")
    @ApiOperation("获取用户身份信息")
    public AjaxResult userInfo(@RequestBody UserRequestVo userRequestVo){
        return AjaxResult.success(appUserService.userInfo(userRequestVo));
    }

    @PostMapping(value = "/timesLimit")
    @ApiOperation("查询用户扫码次数信息")
    public AjaxResult timesLimit(String  idNo){
        return AjaxResult.success(appUserService.timesLimit(idNo));
    }


    @PostMapping(value = "/list")
    @ApiOperation("查询用户列表")
    public AjaxResult list(@RequestBody UserRequestVo userRequestVo){
        return AjaxResult.success(appUserService.queryUserList(userRequestVo));
    }

    @PostMapping("/export")
    public void export(HttpServletResponse response, UserRequestVo userRequestVo)
    {
        List<UserResponseVo> list = appUserService.selectUserListForExport(userRequestVo);
        ExcelUtil<UserResponseVo> util = new ExcelUtil<>(UserResponseVo.class);
        util.exportExcel(response, list, "用户数据");
    }

    @PostMapping(value = "/scan/list")
    @ApiOperation("查询用户列表")
    public AjaxResult scanList(@RequestBody AppScanRecordRequestVo appScanRecordRequestVo){
        return AjaxResult.success(appScanRecordService.queryScanList(appScanRecordRequestVo));
    }

}
