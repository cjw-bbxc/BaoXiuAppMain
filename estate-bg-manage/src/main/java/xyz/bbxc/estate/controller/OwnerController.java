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

    @RequestMapping("/add")
    public Result add(@RequestBody Owner owner) {
        ownerService.add(owner);
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

}
