package com.tanglinkai.mall;

import com.tanglinkai.mall.contstants.Constants;
import com.tanglinkai.mall.entity.Manager;
import com.tanglinkai.mall.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
public class ManagerServiceTest {

	@Autowired
	private ManagerService managerService;

	@Test
	void saveTest() {
		Manager manager = new Manager();
		manager.setAccount("admin");
		manager.setPassword("123456");
		manager.setStatus("y");
		managerService.addAccount(manager);
	}

	@Test
	void loginTest() {
		Manager admin = managerService.login(Constants.DEFAULT_ACCOUNT, Constants.DEFAULT_PASSWORD);
		log.info("登录的用户是{}",admin);
	}
}
