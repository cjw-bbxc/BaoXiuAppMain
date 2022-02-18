package xyz.bbxc.estate.controller.flutter;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.bbxc.estate.damain.Repaired;
import xyz.bbxc.estate.service.flutter.FormCommitService;
import xyz.bbxc.estate.util.DataUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Classname FormSend
 * @Description TODO
 * @Date 2021-4-3 15:44
 * @Created by 白白小草
 */
@RestController
@RequestMapping("/Get")
public class FormReceiveController {

    @Autowired
    private FormCommitService formCommitService;

    /**
     * 接收用户Flutter端提交的报修表单
     *
     * @param formMap
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/Receive")
    public void FormReceive(@RequestBody Map formMap, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        System.out.println("formMap:" + formMap);

        Repaired repaired = DataUtils.MapToEntry(formMap);

        int add = formCommitService.add(repaired);

        if (add != 0) {
            response.getWriter().println("ok");
        }
    }

    /**
     * 接收检修员名称，返回数据库中所有与该名称有关的的数据。使用JSON返回
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/ListAll")
    public void ListAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Repaired> repairers = formCommitService.searchAll();
        response.setCharacterEncoding("utf-8");
        JSONArray jsonArray = JSONArray.fromObject(repairers);

        System.out.println(jsonArray);
        response.getWriter().println(jsonArray);
    }

    @RequestMapping(value = "/ListRepairers")
    public void ListRepairers(@RequestBody String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Repaired> repairers = formCommitService.searchAllByName(name);

        JSONArray jsonArray = JSONArray.fromObject(repairers);
        System.out.println(jsonArray);
        response.setCharacterEncoding("utf-8");
        response.getWriter().println(jsonArray);
    }

    @RequestMapping(value = "/ListOwners")
    public void ListOwners(@RequestBody String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Repaired> repairers = formCommitService.searchAllByOwnerName(name);
        response.setCharacterEncoding("utf-8");

        JSONArray jsonArray = JSONArray.fromObject(repairers);
        System.out.println(jsonArray);

        response.getWriter().println(jsonArray);

    }
}
