package com.eendtech.cqutsmartwatchapp.model.preferences;

import android.content.Context;


import com.eendtech.cqutsmartwatchapp.manager.preferences.DefaultPreference;
import com.eendtech.cqutsmartwatchapp.model.base.UserModel;
import com.google.gson.Gson;

public class UserPreference extends DefaultPreference {

    private final static String KEY_CQUT_USER_INFO = "cqut_userInfo";

    private final Gson gson = new Gson();


    public UserPreference(Context context) {
        super(context);
    }

    /**
     * 记录当前用户信息
     *
     * @param userModel 用户信息模型
     * @return this
     */
    public UserPreference setUserInfo(UserModel userModel) {
        // 对当前的用户model进行JSON序列化
        getPreferences()
                .putString(KEY_CQUT_USER_INFO, gson.toJson(userModel))
                .commit();
        return this;
    }

    /**
     * 获得当前用户信息
     * @return UserModel
     */
    public UserModel getUserInfo() {
        UserModel userModel = new UserModel()
                .setLogin(false);
        return gson.fromJson(getPreferences().getString(KEY_CQUT_USER_INFO, gson.toJson(userModel)), UserModel.class);
    }

    /**
     * 清除key下的数据
     */
    public void clear(String name){
        getPreferences().remove(name);
    }

    /**
     * 清除所有数据
     */
    public void clearAll(){
        getPreferences().clear();
    }


}
