package com.eendtech.cqutsmartwatchapp.utils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class StringUtil {
    public static boolean isNotBlank(String... str){
        AtomicBoolean flag = new AtomicBoolean(true);
        Arrays.stream(str).forEach(s -> flag.set(s != null && !s.equals("") && !s.trim().equals("")));

        return flag.get();
    }
}
