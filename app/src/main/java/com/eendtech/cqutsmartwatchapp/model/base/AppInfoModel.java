package com.eendtech.cqutsmartwatchapp.model.base;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AppInfoModel {
    // APP是否为第一次使用
    private boolean isFirstUse;

}
