package xyz.bbxc.estate.controller.flutter;

import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.bbxc.estate.damain.Owner;
import xyz.bbxc.estate.service.flutter.UserSearchInfoService;
import xyz.bbxc.estate.util.DataUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Classname LoginInfo
 * @Description TODO
 * @Date 2021-4-2 23:08:11
 * @Created by 白白小草
 */
@RestController
@RequestMapping("/Get")
public class LoginInfoController {

    @Autowired
    private UserSearchInfoService userSearchInfoService;

    /**
     * 功能描述: 判断用户登录
     * requestBody: 接受json发送的字符串
     *
     * @param request  请求对象
     * @param response 响应对象
     * @return : JSONObject
     */
    @RequestMapping(value = "/LoginInfo")
    public void getInfo(@RequestBody Map searchMap, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        JSONObject returnJson = null;
        //验证是否存在
        Owner searchOwner = userSearchInfoService.search((String) searchMap.get("username"), (String) searchMap.get("password"));
//        System.out.println("查询结束");
        Map returnmap = null;
        if (searchOwner != null) {
            try {
//                System.out.println(searchOwner);
                returnmap = BeanUtils.describe(searchOwner);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            returnJson = JSONObject.fromObject(returnmap);
        }

        //前端需要返回用户的手机号和用户名以及头像等信息。
        response.getWriter().print(returnJson);
    }

    @RequestMapping(value = "/checkTel")
    public void checkTel(@RequestBody String telephone, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
//        System.out.println("telephone:" + telephone);

        int add = userSearchInfoService.searchByTel(telephone);

        if (add == 0) {
            response.getWriter().println("ok");
            System.out.println("手机号未注册");
        }
    }

    @RequestMapping("/addForFlutter")
    public void addForFlutter(@RequestBody Owner owner, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        int add = userSearchInfoService.add(owner);
        if (add != 0) {
            response.getWriter().println("ok");
//            System.out.println("ok");
        }
    }

    /**
     * 判断用户是否存在
     * @param searchMap
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/checkMsg")
    public void checkMsg(@RequestBody Map searchMap, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        Owner owner = DataUtils.MapToEntryOwn(searchMap);
        //验证是否存在
        int isExist = userSearchInfoService.searchUser(owner);
        if (isExist != 0) {
            response.getWriter().println("ok");
            System.out.println("确认存在该用户，允许修改密码 ");
        }
    }

    @RequestMapping(value = "/setPwd")
    public void setPwd(@RequestBody Map searchMap, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        String telephone = (String) searchMap.get("telephone");
        String password = (String) searchMap.get("password");
        //验证是否存在
        int isExist = userSearchInfoService.UpdatePwd(telephone,password);
        if (isExist != 0) {
            response.getWriter().println("ok");
            System.out.println("修改密码成功 --- ok");
        }
    }

}
