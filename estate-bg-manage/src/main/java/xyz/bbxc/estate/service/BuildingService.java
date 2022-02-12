package xyz.bbxc.estate.service;

import com.github.pagehelper.Page;
import xyz.bbxc.estate.damain.Building;

import java.util.List;
import java.util.Map;

/**
 * @Auth: zhuan
 * @Desc: 小区-业务层接口
 * @DateTime: 2020/12/13 9:52
 */
public interface BuildingService {

    /**
     * 功能描述: 小区查询接口，根据条件查询小区列表（注：支持多条件查询）
     * @param searchMap 前台传递的查询条件
     * @return : java.util.List<com.heima.estatemanagement.domain.Building>
     */
    Page<Building> search(Map searchMap);
    /**
     * 功能描述: 小区新增接口，新增小区信息
     * @param building
     * @return : java.lang.Boolean
     */
    Boolean add(Building building);
    /**
     * 功能描述: 小区修改接口，对已经存在的小区的信息进行修改操作
     * @param building
     * @return : java.lang.Boolean
     */
    Boolean update(Building building);
    /**
     * 功能描述: 小区删除接口，删除已经存在的单个小区
     * @param id
     * @return : java.lang.Boolean
     */
    void del(Integer id);
    /**
     * 功能描述: 小区删除接口，删除已经存在的多个小区
     * @param ids
     * @return : java.lang.Boolean
     */
    Boolean deleteSelect(List<Integer> ids);
    /**
     * 功能描述: 根据小区ID获取小区对象
     * @param id
     * @return : com.heima.estatemanagement.domain.Building
     */
    Building findByID(Integer id);

    /**
     * 功能描述: 小区查询接口，根据条件查询小区列表
     * @param communityName 前台传递的查询条件
     * @return : java.util.List<com.heima.estatemanagement.domain.Building>
     */
    List<Building> searchBycommunityName(String communityName);
}
