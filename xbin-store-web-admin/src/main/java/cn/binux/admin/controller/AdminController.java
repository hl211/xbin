package cn.binux.admin.controller;

import cn.binux.admin.service.RoleService;
import cn.binux.admin.service.UserRoleService;
import cn.binux.admin.service.UserService;
import cn.binux.admin.vo.ManageUserVO;
import cn.binux.constant.Const;
import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysRole;
import cn.binux.pojo.sys.SysUser;
import cn.binux.pojo.sys.SysUserRole;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Random;


/**
 * Admin 首页Controller
 *
 * @author xubin.
 * @create 2017-02-11 下午3:38
 */

@Controller
public class AdminController {


    @Reference(version = Const.XBIN_STORE_API_VERSION)
    private UserService userService;

    @Reference(version = Const.XBIN_STORE_API_VERSION)
    private RoleService roleService;

    @Reference(version = Const.XBIN_STORE_API_VERSION)
    private UserRoleService userRoleService;


    private Random random = new Random();

    @RequestMapping("/index")
    public String showIndex(Model model) {

        ManageUserVO userVO = new ManageUserVO();
        userVO.setCreated(new Date());
        userVO.setName("許彬");
        userVO.setJob("CEO");

        model.addAttribute("user", userVO);

        return "index";
    }
    @RequestMapping("/admin")
    public String showAdmin(Model model) {

        ManageUserVO userVO = new ManageUserVO();
        userVO.setCreated(new Date());
        userVO.setName("李辉");
        userVO.setJob("CEO");

        model.addAttribute("user", userVO);

        return "admin";
    }

    @RequestMapping("/admin1")
    public String showAdmin1(Model model) {

        ManageUserVO userVO = new ManageUserVO();
        userVO.setCreated(new Date());
        userVO.setName("李辉");
        userVO.setJob("CEO");

        model.addAttribute("user", userVO);

        return "admin1";
    }
    @RequestMapping("/show/logo")
    public String showLogo(Model model) {
        int nub = random.nextInt(60000);

        model.addAttribute("random", nub);

        return "editlogo";
    }

    @RequestMapping("/show/eidtItem")
    public String showEidtItem(Model model) {
        int nub = random.nextInt(60000);

        model.addAttribute("random", nub);

        return "editItem";
    }

    @RequestMapping("/show/addItem")
    public String showAddItem(Model model) {
        int nub = random.nextInt(60000);

        model.addAttribute("random", nub);

        return "addItem";
    }
    @RequestMapping("/show/category")
    public String showCategory(Model model) {
        int nub = random.nextInt(60000);
        model.addAttribute("random", nub);

        return "category";
    }


    @RequestMapping("/show/userManagement")
    public String showuserManagement(Model model) {
        int nub = random.nextInt(60000);
        model.addAttribute("random", nub);

        return "../pages/userManagement";
    }

    /**
     * describe: TODO user
     * creat_user: hl
     * creat_date: 2018-04-02
     * creat_time: 21:32
     **/
    @RequestMapping(value = "/user" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getUserData(Integer pageIndex, Integer pageSize) {
        //获取用户
        Map<String, Object> map= userService.getSysUserList(pageIndex,pageSize);
        //获取用户对应的角色
        ArrayList list=(ArrayList)map.get("aData");
        for (Object o:list){
            Long uid=((SysUser)o).getUserId();
            ((SysUser)o).setRoles(roleService.getSysRoleByUserId(uid.intValue()));
        }
        return map;
    }
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    @ResponseBody
    public XbinResult addUserData(String userAccount, String userPass,
                                  String userTel, String userEmail, String userSex,
                                  String userStatus, HttpServletRequest request) {
        String[] ids=request.getParameterValues("RoleId[]");
        //添加该用户
        SysUser sysUser=new SysUser();
        sysUser.setUserAccount(userAccount);
        sysUser.setUserPass(userPass);
        sysUser.setUserTel(userTel);
        sysUser.setUserEmail(userEmail);
        sysUser.setUserStatus(Integer.valueOf(userStatus));
        sysUser.setUserSex(Integer.valueOf(userSex));
        sysUser.setUserRegisterDate(new Date().toString());

        XbinResult xbinResult=userService.saveSysUser(sysUser);
        //添加角色为该用户
        boolean flag=true;
        if(xbinResult.isOK()){
            Long uid=(Long) xbinResult.getData();
            for(String id:ids) {
                SysUserRole sysUserRole=new SysUserRole();
                sysUserRole.setUserId(uid);
                sysUserRole.setRoleId(Integer.valueOf(id));
                if(!userRoleService.saveSysUserRole(sysUserRole).isOK()){
                    flag=false;
                    continue;

                }
            }
        }
        return flag==true?XbinResult.ok():XbinResult.build(400,"error");
    }
    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
    @ResponseBody
    public XbinResult delUserData( String ids) {
        if(ids!=null) {
        String[] uids=ids.split(",");

        //先删除角色
        userRoleService.deleteSysUserRoleByUid(uids);
        //删除用户
        XbinResult result = userService.deleteSysUserById(uids);
            return result;
        }
        return XbinResult.build(400,"ids为空");
    }

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    @ResponseBody
    public XbinResult updateUserData(Model model, String IDS) {
        String[] list=IDS.split(",");
        XbinResult result = userService.deleteSysUserById(list);
        return result;
    }

    /**
     * describe: TODO Role
     * creat_user: hl
     * creat_date: 2018-04-02
     * creat_time: 21:48
     **/
    @RequestMapping(value = "/role" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRoleData(Integer pageIndex, Integer pageSize) {
        Map<String, Object> lists = roleService.getSysRoleList(pageIndex,pageSize);
        return lists;
    }
    @RequestMapping(value = "/role/all" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getRoleAllData(Integer pageIndex, Integer pageSize) {
        Map<String, Object> lists = roleService.getSysRoleAll();
        return lists;
    }
    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
    @ResponseBody
    public XbinResult addRoleData(SysRole sysRole) {
        XbinResult result = roleService.saveSysRole(sysRole);
        return result;
    }
    @RequestMapping(value = "/role/delete",method = RequestMethod.POST)
    @ResponseBody
    public XbinResult delRoleData( String IDS) {
        String[] list=IDS.split(",");
        XbinResult result = roleService.deleteSysRoleById(list);
        return result;
    }
    @RequestMapping(value = "/role/update",method = RequestMethod.POST)
    @ResponseBody
    public XbinResult updateRoleData(Model model,SysRole sysRole) {
        XbinResult result = roleService.saveSysRole(sysRole);
        return result;
    }
/**
 * describe: TODO  permission
 * creat_user: hl
 * creat_date: 2018-04-02
 * creat_time: 21:50
 **/


/**
 * describe: TODO  user-role
 * creat_user: hl
 * creat_date: 2018-04-02
 * creat_time: 21:51
 **/
    @RequestMapping(value = "/userrole" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getUserRoleData(Integer pageIndex, Integer pageSize) {
        Map<String, Object> lists = userService.getSysUserRole(pageIndex,pageSize);
        return lists;
    }
    @RequestMapping(value = "/userrole/add", method = RequestMethod.POST)
    @ResponseBody
    public XbinResult addUserRoleData(SysUser sysUser) {
        XbinResult result = userService.saveSysUser(sysUser);
        return result;
    }
    @RequestMapping(value = "/userrole/delete",method = RequestMethod.POST)
    @ResponseBody
    public XbinResult delUserRoleData( String IDS) {
        String[] list=IDS.split(",");
        XbinResult result = userService.deleteSysUserById(list);
        return result;
    }
}
