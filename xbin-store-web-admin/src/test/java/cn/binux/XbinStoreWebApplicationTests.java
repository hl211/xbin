package cn.binux;

import cn.binux.admin.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@Controller
@RunWith(SpringRunner.class)
@SpringBootTest(classes = XbinStoreWebAdminApplication.class)
public class XbinStoreWebApplicationTests {

	@Reference
	private UserService userService;

	@Test
	public void contextLoads() {
	}


    @Test
	public void getUserData(){
		Map<String, Object> lists = userService.getSysUserList(1,1);
		System.out.println(lists.get("aData"));
	}

}
