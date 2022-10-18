package com.ruoyi.ruoyiapp.response;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseListVo {

    private List<UserResponseVo> userResponseVoList;

    private int total;
}
