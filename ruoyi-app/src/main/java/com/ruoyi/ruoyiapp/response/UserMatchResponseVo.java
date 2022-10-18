package com.ruoyi.ruoyiapp.response;

import com.ruoyi.ruoyiapp.entity.AppUserEntity;
import lombok.Data;

@Data
public class UserMatchResponseVo extends AppUserEntity {
    private String resultCode;
}
