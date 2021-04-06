package xyz.bbxc.estate.service.flutter.impl;/**
 * @Classname FormCommitServiceImpl
 * @Description TODO
 * @Date 2021-4-4 12:09
 * @Created by 白白小草
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.bbxc.estate.damain.Repaired;
import xyz.bbxc.estate.dao.flutter.FormCommitMapper;
import xyz.bbxc.estate.service.flutter.FormCommitService;

import java.util.List;

/**
 * @Classname FormCommitServiceImpl
 * @Description TODO
 * @Date 2021-4-4 12:09
 * @Created by 白白小草
 */
@Service
public class FormCommitServiceImpl implements FormCommitService {

    @Autowired
    private FormCommitMapper formCommitMapper;

    @Override
    @Transactional
    public int add(Repaired repaired) {
        int insert = formCommitMapper.insert(repaired);
        return insert;
    }

    @Override
    public List<Repaired> searchAll() {
        return formCommitMapper.selectAll();
    }
}
