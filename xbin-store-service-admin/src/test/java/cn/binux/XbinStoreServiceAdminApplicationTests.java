package cn.binux;

import cn.binux.admin.service.UserService;
import cn.binux.pojo.sys.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = XbinStoreServiceAdminApplication.class)
public class XbinStoreServiceAdminApplicationTests {

   @Autowired
   private UserService us;
	@Test
	public void contextLoads() {
		SysUser sysUser=new SysUser();
		List<SysUser> list=us.getSysUserRoleByBean(sysUser);
		System.out.println(list.size());
	}

}
