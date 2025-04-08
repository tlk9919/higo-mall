package com.tanglinkai.mall;

import com.tanglinkai.mall.entity.Manager;
import com.tanglinkai.mall.mapper.ManagerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManagerMapperTest {

	@Autowired
	private ManagerMapper managerMapper;

	@Test
	public void testInsertManager() {
		Manager manager = new Manager();
		manager.setAccount("tom");
		manager.setPassword("123456");
		manager.setStatus("y");
		managerMapper.insert(manager);
	}

}
