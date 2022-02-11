package com.eendtech.cqutsmartwatchapp.model.base;

import lombok.Data;
import lombok.experimental.Accessors;

@Data @Accessors(chain = true)
public class UserModel {
    // 昵称
    private String nickName;
    // 用户名
    private String userName;
    // 当前是否登录
    private boolean isLogin;
    // 上次登录时间
    private String lastLoginDate;
    // 当前登录的Token,用于之后的接口权限验证请求等
    private String token;

}
