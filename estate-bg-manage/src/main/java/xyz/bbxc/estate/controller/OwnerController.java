package xyz.bbxc.estate.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.bbxc.estate.common.MessageConstant;
import xyz.bbxc.estate.common.PageResult;
import xyz.bbxc.estate.common.Result;
import xyz.bbxc.estate.common.StatusCode;
import xyz.bbxc.estate.damain.Owner;
import xyz.bbxc.estate.service.OwnerService;
import xyz.bbxc.estate.util.DateUtils;

import java.util.List;
import java.util.Map;

/**
 * @Classname OwnerController
 * @Description TODO
 * @Date 2021-4-5 14:14
 * @Created by 白白小草
 */
@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping("/searchOwner")
    public PageResult searchOwner(@RequestBody Map searchMap){
        Page<Owner> page = ownerService.searchOwner(searchMap);
        long totalCount = page.getTotal();
        List<Owner> ownerList = page.getResult();
        return new PageResult(true, StatusCode.OK, MessageConstant.OWNER_SEARCH_SUCCESS, ownerList, totalCount);
    }

    @RequestMapping("/searchReg")
    public PageResult searchReg(@RequestBody Map searchMap){
        Page<Owner> page = ownerService.searchReg(searchMap);
        long totalCount = page.getTotal();
        List<Owner> ownerList = page.getResult();
        return new PageResult(true, StatusCode.OK, MessageConstant.OWNER_SEARCH_SUCCESS, ownerList, totalCount);
    }

    @RequestMapping("/searchAllReg")
    public Result searchAllReg(){
        List<Owner> ownerList = ownerService.searchAllReg();
//        System.out.println(ownerList);
        return new Result(true, StatusCode.OK, MessageConstant.OWNER_SEARCH_SUCCESS, ownerList);
    }


    @RequestMapping("/user/add")
    public Result userAdd(@RequestBody Owner owner) {
        owner.setType("0");
        owner.setBirthday(DateUtils.setBirth(owner.getId_card()));
        ownerService.add(owner);
        System.out.println("useradd:"+owner);
        return new Result(true, StatusCode.OK, MessageConstant.OWNER_ADD_SUCCESS);
    }

    @RequestMapping("/repair/add")
    public Result repairAdd(@RequestBody Owner owner) {
        owner.setType("1");
        owner.setProfession("检修员");
        owner.setBirthday(DateUtils.setBirth(owner.getId_card()));
        ownerService.add(owner);
        System.out.println("repair add:"+owner);
        return new Result(true, StatusCode.OK, MessageConstant.OWNER_ADD_SUCCESS);
    }


    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        Owner Owner = ownerService.findByID(id);
        return new Result(true, StatusCode.OK, MessageConstant.OWNER_FIND_BY_ID_SUCCESS, Owner);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Owner Owner) {
        ownerService.update(Owner);
        return new Result(true, StatusCode.OK, MessageConstant.OWNER_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result update(@RequestBody List<Integer> ids) {
        ownerService.delete(ids);
        return new Result(true, StatusCode.OK, MessageConstant.OWNER_DELETE_SUCCESS);
    }

    @RequestMapping("/delSelected")
    public Result delSelected(@RequestBody List<Integer> ids) {
        ownerService.deleteSelect(ids);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }

}
