package xyz.bbxc.estate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;
import xyz.bbxc.estate.damain.House;
import xyz.bbxc.estate.dao.HouseMapper;
import xyz.bbxc.estate.service.HouseService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Classname HouseServiceImpl
 * @Description TODO
 * @Date 2021-4-5 19:45
 * @Created by 白白小草
 */
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public Page<House> search(Map searchMap) {
        Example example = new Example(House.class);
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
        Page<House> housePage = (Page<House>) houseMapper.selectByExample(example);
        return housePage;
    }

    @Override
    public Boolean add(House house) {
        houseMapper.insertSelective(house);
        return true;
    }

    @Override
    public Boolean update(House house) {
        houseMapper.updateByPrimaryKeySelective(house);
        return true;
    }

    @Override
    public void del(Integer id) {
        houseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Boolean deleteSelect(List<Integer> ids) {
        for (Integer id : ids) {
            houseMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public House findByID(Integer id) {
        House house = houseMapper.selectByPrimaryKey(id);
        return house;
    }

}
