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
import xyz.bbxc.estate.damain.House;
import xyz.bbxc.estate.service.HouseService;

import java.util.List;
import java.util.Map;

/**
 * @Auth: 白白小草
 * @Desc: 小区管理-控制层代码
 * @DateTime: 2020/12/13 15:22
 */

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;
    
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        Page<House> page = houseService.search(searchMap);
        long totalCount = page.getTotal();
        List<House> houseList = page.getResult();
        return new PageResult(true, StatusCode.OK, MessageConstant.HOUSE_SEARCH_SUCCESS, houseList, totalCount);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody House house) {
        houseService.add(house);
        return new Result(true, StatusCode.OK, MessageConstant.HOUSE_ADD_SUCCESS);
    }

    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        House house = houseService.findByID(id);
        return new Result(true, StatusCode.OK, MessageConstant.HOUSE_FIND_BY_ID_SUCCESS, house);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody House house) {
        houseService.update(house);
        return new Result(true, StatusCode.OK, MessageConstant.HOUSE_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(Integer id) {
        houseService.del(id);
        return new Result(true, StatusCode.OK, MessageConstant.HOUSE_DELETE_SUCCESS);
    }


    @RequestMapping("/delSelected")
    public Result delSelected(@RequestBody List<Integer> ids) {
        houseService.deleteSelect(ids);
        return new Result(true, StatusCode.OK, MessageConstant.HOUSE_DELETE_SUCCESS);
    }
}
