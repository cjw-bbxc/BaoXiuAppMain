package xyz.bbxc.estate.service.flutter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.bbxc.estate.damain.*;
import xyz.bbxc.estate.dao.flutter.UserSearchMapper;
import xyz.bbxc.estate.service.flutter.*;

import java.util.Date;
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
        System.out.println("owner:::::::::::::::::::"+owner);
        Owner select = userSearchMapper.selectOne(owner);
        return select;
    }

    @Override
    public List<Owner> searchAllByOwnerName(String name) {
        Owner owner = new Owner();
        owner.setName(name);
        return userSearchMapper.select(owner);
    }

    @Override
    public int searchByTel(String telephone) {
        Owner owner = new Owner();
        owner.setTelephone(telephone);
//        System.out.println(owner);
        List<Owner> select = userSearchMapper.select(owner);
//        System.out.println("size:"+select.size());
        return select.size();
    }

    @Override
    public int add(Owner owner) {
        owner.setUpdate_time(new Date());
        int insert = userSearchMapper.insert(owner);
        return insert;
    }

    @Override
    public int searchUser(Owner owner) {
        return userSearchMapper.selectCount(owner);
    }

    @Override
    public int UpdatePwd(String telephone, String password) {
        Owner owner = new Owner();
        owner.setTelephone(telephone);
        Owner searchOwner = userSearchMapper.selectOne(owner);
        searchOwner.setPassword(password);
        searchOwner.setUpdate_time(new Date());
        return userSearchMapper.updateByPrimaryKey(searchOwner);
    }
}
