package xyz.bbxc.estate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;
import xyz.bbxc.estate.damain.Owner;
import xyz.bbxc.estate.dao.OwnerMapper;
import xyz.bbxc.estate.service.OwnerService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Classname OwnerServiceImpl
 * @Description TODO
 * @Date 2021-4-5 14:17
 * @Created by 白白小草
 */
@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public Page<Owner> searchOwner(Map searchMap) {
        Example example = new Example(Owner.class);
        //1.初始化分页条件
        int pageNum = 1;
        int pageSize = 10;
        //2.判断请求条件是否为空，不为空则根据searchMap中条件，封装SQL查询条件
        if (searchMap != null) {
            Example.Criteria criteria = example.createCriteria();
            //设置查询条件为业主
            criteria.andEqualTo("type", "0");
            //大于开始时间
            if (StringUtil.isNotEmpty((String) searchMap.get("startTime"))) {
                criteria.andGreaterThanOrEqualTo("create_time", searchMap.get("startTime"));
            }
            //小于结束时间
            if (StringUtil.isNotEmpty((String) searchMap.get("endTime"))) {
                criteria.andLessThanOrEqualTo("update_time", searchMap.get("endTime"));
            }
            //根据名称模糊查询
            if (StringUtil.isNotEmpty((String) searchMap.get("name"))) {
                String name = (String) searchMap.get("name");
                criteria.andLike("name", "%" + name.trim() + "%");
            }
            //分页条件
            if (searchMap.get("pageNum") != null) {
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if (searchMap.get("pageSize") != null) {
                pageSize = (Integer) searchMap.get("pageSize");
            }
        }
        //使用PageHelper插件拼接分页条件（注意：）
        PageHelper.startPage(pageNum, pageSize);
        Page<Owner> owner = (Page<Owner>) ownerMapper.selectByExample(example);
        return owner;
    }

    @Override
    public Page<Owner> searchReg(Map searchMap) {
        Example example = new Example(Owner.class);
        //1.初始化分页条件
        int pageNum = 1;
        int pageSize = 10;
        //2.判断请求条件是否为空，不为空则根据searchMap中条件，封装SQL查询条件
        if (searchMap != null) {
            Example.Criteria criteria = example.createCriteria();
            //设置查询条件为业主
            criteria.andEqualTo("type", "1");
            //大于开始时间
            if (StringUtil.isNotEmpty((String) searchMap.get("startTime"))) {
                criteria.andGreaterThanOrEqualTo("create_time", searchMap.get("startTime"));
            }
            //小于结束时间
            if (StringUtil.isNotEmpty((String) searchMap.get("endTime"))) {
                criteria.andLessThanOrEqualTo("update_time", searchMap.get("endTime"));
            }
            //根据名称模糊查询
            if (StringUtil.isNotEmpty((String) searchMap.get("name"))) {
                String name = (String) searchMap.get("name");
                criteria.andLike("name", "%" + name.trim() + "%");
            }
            //分页条件
            if (searchMap.get("pageNum") != null) {
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if (searchMap.get("pageSize") != null) {
                pageSize = (Integer) searchMap.get("pageSize");
            }
        }
        //使用PageHelper插件拼接分页条件（注意：）
        PageHelper.startPage(pageNum, pageSize);
        Page<Owner> owner = (Page<Owner>) ownerMapper.selectByExample(example);
        return owner;
    }

    @Override
    @Transactional
    public Boolean add(Owner owner) {
        owner.setUpdate_time(new Date());
        ownerMapper.insertSelective(owner);
        return true;
    }

    @Override
    @Transactional
    public Boolean update(Owner owner) {
        ownerMapper.updateByPrimaryKeySelective(owner);
        return true;
    }

    @Override
    @Transactional
    public Boolean delete(List<Integer> ids) {
        for (Integer id : ids) {
            ownerMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    @Transactional
    public Owner findByID(Integer id) {
        return ownerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Owner> searchAllReg() {
        Example example = new Example(Owner.class);
        Example.Criteria criteria = example.createCriteria();
        //设置查询条件为检修员
        criteria.andEqualTo("type", "1");
        return ownerMapper.selectByExample(example);
    }

}
