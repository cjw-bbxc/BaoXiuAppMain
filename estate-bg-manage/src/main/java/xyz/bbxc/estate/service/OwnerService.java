package xyz.bbxc.estate.service;

import com.github.pagehelper.Page;
import xyz.bbxc.estate.damain.Owner;

import java.util.List;
import java.util.Map;

public interface OwnerService {
    /**
     * 功能描述: 用户查询接口，根据条件查询用户列表（注：支持多条件查询）
     * @param searchMap 前台传递的查询条件
     * @return : java.util.List<com.heima.estatemanagement.domain.owner>
     */
    Page<Owner> searchOwner(Map searchMap);
    /**
     * 功能描述: 检修员查询接口，根据条件查询检修员列表（注：支持多条件查询）
     * @param searchMap 前台传递的查询条件
     * @return : java.util.List<com.heima.estatemanagement.domain.owner>
     */
    Page<Owner> searchReg(Map searchMap);
    /**
     * 功能描述: 用户新增接口，新增用户信息
     * @param owner
     * @return : java.lang.Boolean
     */
    Boolean add(Owner owner);
    /**
     * 功能描述: 用户修改接口，对已经存在的用户的信息进行修改操作
     * @param owner
     * @return : java.lang.Boolean
     */
    Boolean update(Owner owner);
    /**
     * 功能描述: 用户删除接口，删除已经存在的用户，支持单个、多个删除
     * @param ids
     * @return : java.lang.Boolean
     */
    Boolean delete(List<Integer> ids);
    /**
     * 功能描述: 根据用户ID获取用户对象
     * @param id
     * @return : com.heima.estatemanagement.domain.owner
     */
    Owner findByID(Integer id);
}
