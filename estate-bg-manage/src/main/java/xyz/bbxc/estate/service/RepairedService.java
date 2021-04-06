package xyz.bbxc.estate.service;

import com.github.pagehelper.Page;
import xyz.bbxc.estate.damain.Repaired;

import java.util.List;
import java.util.Map;

/**
 * @Auth: zhuan
 * @Desc: 房产-业务层接口
 * @DateTime: 2020/12/13 9:52
 */
public interface RepairedService {

    /**
     * 功能描述: 房产查询接口，根据条件查询房产列表（注：支持多条件查询）
     * @param searchMap 前台传递的查询条件
     * @return : java.util.List<com.heima.estatemanagement.domain.Repaired>
     */
    Page<Repaired> search(Map searchMap);
    /**
     * 功能描述: 房产新增接口，新增房产信息
     * @param Repaired
     * @return : java.lang.Boolean
     */
    Boolean add(Repaired Repaired);
    /**
     * 功能描述: 房产修改接口，对已经存在的房产的信息进行修改操作
     * @param Repaired
     * @return : java.lang.Boolean
     */
    Boolean update(Repaired Repaired);
    /**
     * 功能描述: 房产删除接口，删除已经存在的单个房产
     * @param id
     * @return : java.lang.Boolean
     */
    void del(Integer id);
    /**
     * 功能描述: 房产删除接口，删除已经存在的多个房产
     * @param ids
     * @return : java.lang.Boolean
     */
    Boolean deleteSelect(List<Integer> ids);
    /**
     * 功能描述: 根据房产ID获取房产对象
     * @param id
     * @return : com.heima.estatemanagement.domain.Repaired
     */
    Repaired findByID(Integer id);

}
