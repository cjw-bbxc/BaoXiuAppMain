package xyz.bbxc.estate.service.flutter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.bbxc.estate.damain.*;
import xyz.bbxc.estate.dao.flutter.UserSearchMapper;
import xyz.bbxc.estate.service.flutter.*;

import java.util.List;

/**
 * @Classname UserSearchInfoServiceImpl
 * @Description TODO
 * @Date 2021-4-2 23:51
 * @Created by 白白小草
 */
@Service
public class UserSearchInfoServiceImpl implements UserSearchInfoService {

    @Autowired
    private UserSearchMapper userSearchMapper;

    @Override
    public Owner search(String phoneNumber, String password) {
        Owner owner = new Owner();
        owner.setTelephone(phoneNumber);
        owner.setPassword(password);
        Owner select = userSearchMapper.selectOne(owner);
        return select;
    }
}
