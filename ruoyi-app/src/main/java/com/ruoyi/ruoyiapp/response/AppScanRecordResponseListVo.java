package com.ruoyi.ruoyiapp.response;

import lombok.Data;

import java.util.List;

@Data
public class AppScanRecordResponseListVo {

    private List<AppScanRecordResponseVo> appScanRecordResponseVos;

    private int total;
}
