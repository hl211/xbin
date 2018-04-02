package cn.binux.admin.service;

import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysUser;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * class_name: cn.binx.shiro.service
     * package: ShiroService
     * describe: TODO
     * creat_user: hl
     * creat_date: 2018-03-20
     * creat_time: 15:53
     **/
      Map<String, Object> getSysUserList(Integer pageIndex, Integer pageSize);
      Map<String, Object> getSysUserList(Integer pageIndex, Integer pageSize,SysUser user);
      List<SysUser> getSysUserByBean(SysUser user);
      XbinResult saveSysUser(SysUser user);
      XbinResult deleteSysUserById(String [] id);

      List<SysUser> getSysUserRoleByBean(SysUser user);

}
