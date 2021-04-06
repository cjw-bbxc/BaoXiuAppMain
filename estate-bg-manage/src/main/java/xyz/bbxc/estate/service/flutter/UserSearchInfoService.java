package xyz.bbxc.estate.service.flutter;

import xyz.bbxc.estate.damain.Owner;
import xyz.bbxc.estate.damain.Repaired;

/**
 * @Classname UserSearchInfoService
 * @Description TODO
 * @Date 2021-4-2 23:51
 * @Created by 白白小草
 */
public interface UserSearchInfoService {

    Owner search(String phoneNumber, String password);

}
