package xyz.bbxc.estate.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname DateUtils
 * @Description TODO
 * @Date 2021-4-4 11:51
 * @Created by 白白小草
 */
public class DateUtils {

    public static String getDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }
}
