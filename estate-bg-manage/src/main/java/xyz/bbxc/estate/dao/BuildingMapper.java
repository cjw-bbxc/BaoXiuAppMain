package xyz.bbxc.estate.dao;


import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import xyz.bbxc.estate.damain.Building;

/**
 * @Auth: zhuan
 * @Desc: 小区持久层接口，继承了TKMapper的Mapper<T>接口，默认具有对单表tb_community的CRUD（增删改查）操作
 * @DateTime: 2020/12/13 9:42
 */
@Repository
public interface BuildingMapper extends Mapper<Building> {

}
