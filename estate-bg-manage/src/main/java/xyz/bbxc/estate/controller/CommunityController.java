package xyz.bbxc.estate.controller;

import com.github.pagehelper.Page;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bbxc.estate.common.*;
import xyz.bbxc.estate.damain.*;
import xyz.bbxc.estate.service.*;

import java.util.List;
import java.util.Map;

/**
 * @Auth: 白白小草
 * @Desc: 小区管理-控制层代码
 * @DateTime: 2020/12/13 15:22
 */

@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        Page<Community> page = communityService.search(searchMap);
        long totalCount = page.getTotal();
        List<Community> communityList = page.getResult();
//        System.out.println("List Community:"+communityList);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, communityList, totalCount);
    }

    @RequestMapping("/searchAll")
    public Result searchAll() {
        List<Community> communityList = communityService.searchAll();
        System.out.println("ListAll Community:"+communityList);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_SEARCH_SUCCESS,communityList);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Community community) {
        System.out.println("add Community:"+community);
        communityService.add(community);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_ADD_SUCCESS);
    }

    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        Community community = communityService.findByID(id);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS, community);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Community community) {
        System.out.println("update Community:"+community);
        communityService.update(community);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }

    @RequestMapping("/upStatus/{status}/{id}")
    public Result upStatus(@PathVariable("status") String status, @PathVariable("id") Integer id) {
        communityService.upStatus(status, id);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_UPDATE_STATUS_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(Integer id) {
        communityService.del(id);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }


    @RequestMapping("/delSelected")
    public Result delSelected(@RequestBody List<Integer> ids) {
        communityService.deleteSelect(ids);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }

    public Integer getcommunityid(String communityName){
        return communityService.findByName(communityName);
    }
}
