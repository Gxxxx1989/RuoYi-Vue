package com.ruoyi.ruoyiapp.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 扫码结果返回
 *
 * @author guoxi_789@126.com
 * @date 2022/10/16
 */
@AllArgsConstructor
@Getter
public enum ScanResultEnum {
    /**通过*/
    PASS("PASS", "通过"),
    /**不通过*/
    FAILED("FAILED", "不通过"),
    /**扫码超过次数限制*/
    OVER_LIMIT("OVER_LIMIT", "扫码超过次数限制");

    private String code;
    private String msg;

}
