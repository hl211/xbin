package cn.binux;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.dubbo.container.Main;

@Configuration
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "cn.binux.mapper.sys")
public class XbinStoreServiceShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(XbinStoreServiceShiroApplication.class, args);
		Main.main(args);
	}
}
