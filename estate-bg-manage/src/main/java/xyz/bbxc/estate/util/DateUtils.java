package xyz.bbxc.estate.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname DateUtils
 * @Description TODO  日期相关操作
 * @Date 2022-2-2 11:51
 * @Created by 白白小草
 */
public class DateUtils {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static String getDate(){
        Date date = new Date();
        return sdf.format(date);
    }

    public static String setBirth(String idcard) {
        //通过身份证号码来截取生日
        String s = idcard.substring(6,14);
        //加入-
        String year = s.substring(0,4);
        String month = s.substring(4,6);
        String day = s.substring(6,8);
        return year+"-"+month+"-"+day;
    }

}
