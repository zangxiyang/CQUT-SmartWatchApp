package com.eendtech.cqutsmartwatchapp.constant;

import lombok.Getter;

/**
 * 项目常量池
 */
public class BaseConstant {

    @Getter
    public enum Config {
        SP_NAME("DataStore存储名", "CQUT-SMARTWATCH");

        private final String key;
        private final String val;

        Config(String key, String val) {
            this.key = key;
            this.val = val;
        }
    }
}
