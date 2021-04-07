package xyz.bbxc.estate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;
import xyz.bbxc.estate.damain.Repaired;
import xyz.bbxc.estate.dao.RepairedMapper;
import xyz.bbxc.estate.service.RepairedService;
import xyz.bbxc.estate.util.DateUtils;

import java.util.List;
import java.util.Map;

/**
 * @Classname RepairedServiceImpl
 * @Description TODO
 * @Date 2021-4-5 19:45
 * @Created by 白白小草
 */
@Service
public class RepairedServiceImpl implements RepairedService {

    @Autowired
    private RepairedMapper repairedMapper;

    @Override
    public Page<Repaired> search(Map searchMap) {
        Example example = new Example(Repaired.class);
        //1.初始化分页条件
        int pageNum = 1;
        int pageSize = 10;
        //2.判断请求条件是否为空，不为空则根据searchMap中条件，封装SQL查询条件
        if(searchMap != null){
            Example.Criteria criteria = example.createCriteria();
            //大于开始时间
            if(StringUtil.isNotEmpty((String)searchMap.get("startTime"))){
                criteria.andGreaterThanOrEqualTo("create_time",searchMap.get("startTime"));
            }
            //小于结束时间
            if(StringUtil.isNotEmpty((String)searchMap.get("endTime"))){
                criteria.andLessThanOrEqualTo("create_time",searchMap.get("endTime"));
            }
            //根据名称模糊查询
            if(StringUtil.isNotEmpty((String)searchMap.get("name"))){
                String name = (String) searchMap.get("name");
                criteria.andLike("name","%"+name.trim()+"%");
            }
            //分页条件
            if(searchMap.get("pageNum") !=null){
                pageNum = (Integer)searchMap.get("pageNum");
            }
            if(searchMap.get("pageSize") !=null){
                pageSize = (Integer)searchMap.get("pageSize");
            }
        }
        //使用PageHelper插件拼接分页条件（注意：）
        PageHelper.startPage(pageNum,pageSize);
        Page<Repaired> repairedPage = (Page<Repaired>) repairedMapper.selectByExample(example);
        return repairedPage;
    }

    @Override
    public Boolean add(Repaired repaired) {
        repaired.setCreate_time(DateUtils.getDate());
        repairedMapper.insertSelective(repaired);
        return true;
    }

    @Override
    public Boolean update(Repaired repaired) {
        repairedMapper.updateByPrimaryKeySelective(repaired);
        return true;
    }

    @Override
    public void del(Integer id) {
        repairedMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Boolean deleteSelect(List<Integer> ids) {
        for (Integer id : ids) {
            repairedMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public Repaired findByID(Integer id) {
        Repaired repaired = repairedMapper.selectByPrimaryKey(id);
        return repaired;
    }

    @Override
    public void repairUpdateById(Integer id) {
        Repaired repaired = repairedMapper.selectByPrimaryKey(id);
        repaired.setStatus("2");
        repairedMapper.updateByPrimaryKeySelective(repaired);
    }

    @Override
    public void ownerUpdateById(Integer id) {
        Repaired repaired = repairedMapper.selectByPrimaryKey(id);
        System.out.println("repaired:" + repaired);
        repaired.setStatus("3");
        repairedMapper.updateByPrimaryKeySelective(repaired);
    }

}
