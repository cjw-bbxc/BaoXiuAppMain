package xyz.bbxc.estate.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bbxc.estate.common.MessageConstant;
import xyz.bbxc.estate.common.PageResult;
import xyz.bbxc.estate.common.Result;
import xyz.bbxc.estate.common.StatusCode;
import xyz.bbxc.estate.damain.Building;
import xyz.bbxc.estate.damain.Community;
import xyz.bbxc.estate.service.BuildingService;

import java.util.List;
import java.util.Map;

/**
 * @Auth: 白白小草
 * @Desc: 小区管理-控制层代码
 * @DateTime: 2020/12/13 15:22
 */

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private CommunityController communityController;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        Page<Building> page = buildingService.search(searchMap);
        long totalCount = page.getTotal();
        List<Building> buildingList = page.getResult();
//        System.out.println("List Building:"+buildingList);
        return new PageResult(true, StatusCode.OK, MessageConstant.BUILDING_SEARCH_SUCCESS, buildingList, totalCount);
    }

    /**
     * 根据 所属小区名称 查询所有所属该 小区 的楼栋数
     * @param name
     * @return
     */
    @RequestMapping("/searchBycommunityName")
    public Result searchBycommunityName(String name) {
//        System.out.println("username:"+username);
        System.out.println("communityName:"+name);
        List<Building> buildingList = buildingService.searchBycommunityName(name);
//        System.out.println(buildingList);
        return new Result(true,StatusCode.OK,MessageConstant.BUILDING_SEARCH_SUCCESS,buildingList);
    }


    @RequestMapping("/add")
    public Result add(@RequestBody Building building) {
//        System.out.println("add Building:"+building);
        int communityid = communityController.getcommunityid(building.getCommunityName());
        building.setCommunityId(communityid);
//        System.out.println("building---------"+building);
        buildingService.add(building);
        return new Result(true, StatusCode.OK, MessageConstant.BUILDING_ADD_SUCCESS);
    }

    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        Building building = buildingService.findByID(id);
        return new Result(true, StatusCode.OK, MessageConstant.BUILDING_FIND_BY_ID_SUCCESS, building);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Building building) {
        System.out.println("update Building:"+building);
        buildingService.update(building);
        return new Result(true, StatusCode.OK, MessageConstant.BUILDING_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(Integer id) {
        buildingService.del(id);
        return new Result(true, StatusCode.OK, MessageConstant.BUILDING_DELETE_SUCCESS);
    }


    @RequestMapping("/delSelected")
    public Result delSelected(@RequestBody List<Integer> ids) {
        buildingService.deleteSelect(ids);
        return new Result(true, StatusCode.OK, MessageConstant.BUILDING_DELETE_SUCCESS);
    }
}
