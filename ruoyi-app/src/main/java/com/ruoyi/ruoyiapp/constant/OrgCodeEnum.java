package com.ruoyi.ruoyiapp.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrgCodeEnum {
    /**
     * 精美达
     */
    JMD("JMD", "精美达"),
    /**
     * 大检
     */
    DJ("DJ", "大检"),
    /**
     * 崇济
     */
    CJ("CJ", "崇济"),
    /**
     * 和合
     */
    HH("HH", "和合"),
    /**
     * 晶泰
     */
    PT("PT", "晶泰");

    private String code;

    private String name;
}
