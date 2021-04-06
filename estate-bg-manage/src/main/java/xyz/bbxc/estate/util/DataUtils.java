package xyz.bbxc.estate.util;

import xyz.bbxc.estate.damain.Repaired;

import java.util.Date;
import java.util.Map;

/**
 * @Classname DataUtils
 * @Description TODO
 * @Date 2021-4-4 14:43
 * @Created by 白白小草
 */
public class DataUtils {

    public static Repaired MapToEntry(Map formMap) {
        Repaired repaired = new Repaired();
        repaired.setName((String) formMap.get("username"));
        repaired.setAddress((String) formMap.get("address"));
        repaired.setTelephone((String) formMap.get("phone"));
        repaired.setType((String) formMap.get("type"));
        repaired.setDescription((String) formMap.get("detail"));
        repaired.setPicture((String) formMap.get("picture"));
        repaired.setStatus("0");
        repaired.setCreate_time(DateUtils.getDate());
        return repaired;
    }

}
