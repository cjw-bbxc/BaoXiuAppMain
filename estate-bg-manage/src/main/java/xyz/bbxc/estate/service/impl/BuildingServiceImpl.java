package xyz.bbxc.estate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;
import xyz.bbxc.estate.damain.Building;
import xyz.bbxc.estate.damain.Building;
import xyz.bbxc.estate.dao.BuildingMapper;
import xyz.bbxc.estate.dao.CommunityMapper;
import xyz.bbxc.estate.service.BuildingService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Classname BuildingServiceImpl
 * @Description TODO
 * @Date 2021-4-5 19:45
 * @Created by 白白小草
 */
@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public Page<Building> search(Map searchMap) {
        Example example = new Example(Building.class);
        //1.初始化分页条件
        int pageNum = 1;
        int pageSize = 10;
        //2.判断请求条件是否为空，不为空则根据searchMap中条件，封装SQL查询条件
        if (searchMap != null) {
            Example.Criteria criteria = example.createCriteria();
            //大于开始时间
            if (StringUtil.isNotEmpty((String) searchMap.get("startTime"))) {
                criteria.andGreaterThanOrEqualTo("create_time", searchMap.get("startTime"));
            }
            //小于结束时间
            if (StringUtil.isNotEmpty((String) searchMap.get("endTime"))) {
                criteria.andLessThanOrEqualTo("create_time", searchMap.get("endTime"));
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
        Page<Building> buildingPage = (Page<Building>) buildingMapper.selectByExample(example);
        return buildingPage;
    }

    @Override
    public Boolean add(Building building) {
        building.setUpdateTime(new Date());
        buildingMapper.insertSelective(building);
        return true;
    }

    @Override
    public Boolean update(Building building) {
        buildingMapper.updateByPrimaryKeySelective(building);
        return true;
    }

    @Override
    public void del(Integer id) {
        buildingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Boolean deleteSelect(List<Integer> ids) {
        for (Integer id : ids) {
            buildingMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public Building findByID(Integer id) {
        Building building = buildingMapper.selectByPrimaryKey(id);
        return building;
    }

    @Override
    public List<Building> searchBycommunityName(String communityName) {

        Building building = new Building();
        building.setCommunityName(communityName);

        List<Building> buildings = buildingMapper.select(building);
        return buildings;
    }

}
