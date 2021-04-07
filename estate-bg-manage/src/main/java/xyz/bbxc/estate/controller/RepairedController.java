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
import xyz.bbxc.estate.damain.Repaired;
import xyz.bbxc.estate.service.RepairedService;

import java.util.List;
import java.util.Map;

/**
 * @Auth: 白白小草
 * @Desc: 小区管理-控制层代码
 * @DateTime: 2020/12/13 15:22
 */

@RestController
@RequestMapping("/repaired")
public class RepairedController {

    @Autowired
    private RepairedService repairedService;
    
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        Page<Repaired> page = repairedService.search(searchMap);
        long totalCount = page.getTotal();
        List<Repaired> repairedList = page.getResult();
        return new PageResult(true, StatusCode.OK, MessageConstant.REPAIRED_SEARCH_SUCCESS, repairedList, totalCount);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Repaired repaired) {
        repairedService.add(repaired);
        return new Result(true, StatusCode.OK, MessageConstant.REPAIRED_ADD_SUCCESS);
    }

    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        Repaired repaired = repairedService.findByID(id);
        return new Result(true, StatusCode.OK, MessageConstant.REPAIRED_FIND_BY_ID_SUCCESS, repaired);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Repaired repaired) {
        //判断是否为派遣
        if(repaired.getRepairManName() != null && "0".equals(repaired.getStatus()) ){
            repaired.setStatus("1");
        }
        System.out.println("repaired:"+repaired);
        repairedService.update(repaired);
        return new Result(true, StatusCode.OK, MessageConstant.REPAIRED_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(Integer id) {
        repairedService.del(id);
        return new Result(true, StatusCode.OK, MessageConstant.REPAIRED_DELETE_SUCCESS);
    }

    @RequestMapping("/delSelected")
    public Result delSelected(@RequestBody List<Integer> ids) {
        repairedService.deleteSelect(ids);
        return new Result(true, StatusCode.OK, MessageConstant.REPAIRED_DELETE_SUCCESS);
    }

    @RequestMapping("/repairUpdateById")
    public void repairUpdateById(@RequestBody Integer id) {
        repairedService.repairUpdateById(id);
    }

    @RequestMapping("/ownerUpdateById")
    public void ownerUpdateById(@RequestBody Integer id) {
        System.out.println("1111111");
        repairedService.ownerUpdateById(id);
    }

}
