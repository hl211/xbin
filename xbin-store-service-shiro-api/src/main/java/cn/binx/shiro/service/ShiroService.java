package cn.binx.shiro.service;

import cn.binux.pojo.XbinResult;

import java.util.List;
import java.util.Map;

/**
 * class_name: cn.binx.shiro.service
 * package: ShiroService
 * describe: TODO
 * creat_user: hl
 * creat_date: 2018-03-20
 * creat_time: 15:53
 **/
public interface ShiroService {

    /**
     *  Sys-User
     */
    Map<String, Object> getSysUserList(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength);
    List<SysUser> getSysUserByBean(SysUser user);
    XbinResult saveSysUser(SysUser user);


    /**
     *
     *  Sys--Role
     */
    Map<String, Object> getSysRoleList(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength);
    List<SysRole> getSysRoleByBean(SysRole role);
    XbinResult saveSysRole(SysRole role);

    /**
     *
     *   Sys--Authority
     */
    Map<String, Object> getSysAuthorityList(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength);
    List<SysAuthority> getSysAuthorityByBean(SysAuthority authority);
    XbinResult saveSysAuthority(SysAuthority authority);

}
