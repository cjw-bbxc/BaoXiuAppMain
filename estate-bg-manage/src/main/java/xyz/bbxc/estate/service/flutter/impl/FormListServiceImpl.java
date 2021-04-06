package xyz.bbxc.estate.service.flutter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.bbxc.estate.damain.Repaired;
import xyz.bbxc.estate.dao.flutter.FormCommitMapper;
import xyz.bbxc.estate.service.flutter.FormListService;

import java.util.List;

/**
 * @Classname FormListServiceImpl
 * @Description TODO
 * @Date 2021-4-4 14:30
 * @Created by 白白小草
 */
@Service
public class FormListServiceImpl implements FormListService {

    @Autowired
    private FormCommitMapper formCommitMapper;

//    @Override
//    public List<Repaired> searchAll() {
//        return formCommitMapper.selectAll();
//    }
}
