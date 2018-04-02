package cn.binux;

import cn.binx.shiro.service.ShiroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=XbinStoreServiceShiroApplication.class)
public class XbinStoreServiceShiroApplicationTests {

	@Autowired
	private ShiroService ss;
	@Test
	public void contextLoads() {
		System.out.println( ss.getSysUserList(0,0,1).get("aData"));

	}

}
