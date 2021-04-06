package xyz.bbxc.estate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import xyz.bbxc.estate.damain.Community;
import xyz.bbxc.estate.dao.CommunityMapper;
import xyz.bbxc.estate.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;
/**
 * @Auth: zhuan
 * @Desc: 小区-业务层具体代码实现
 * @DateTime: 2020/12/13 9:56
 */

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public Page<Community> search(Map searchMap) {
        Example example = new Example(Community.class);
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
        Page<Community> communities = (Page<Community>) communityMapper.selectByExample(example);
        return communities;
    }

    @Override
    public List<Community> searchAll() {
        return communityMapper.selectAll();
    }

    @Override
    @Transactional
    public Boolean add(Community community) {
        communityMapper.insertSelective(community);
        return true;
    }

    @Override
    @Transactional
    public Boolean update(Community community) {
        communityMapper.updateByPrimaryKeySelective(community);
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteSelect(List<Integer> ids) {
        for (Integer id : ids) {
            communityMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public Community findByID(Integer id) {
        Community community = communityMapper.selectByPrimaryKey(id);
        return community;
    }
    @Override
    @Transactional
    public Boolean upStatus(String status, Integer id) {
        Community community = new Community();
        community.setId(id);
        community.setStatus(status);
        communityMapper.updateByPrimaryKeySelective(community);
        return true;
    }

    @Override
    public Integer findByName(String communityName) {
        Community community = new Community();
        community.setName(communityName);
        int id = communityMapper.selectOne(community).getId();
        System.out.println("id-----------------"+id);
        return id;
    }

    @Override
    public void del(Integer id) {
        communityMapper.deleteByPrimaryKey(id);
    }
}
