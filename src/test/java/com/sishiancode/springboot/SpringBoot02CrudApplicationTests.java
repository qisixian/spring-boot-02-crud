package com.sishiancode.springboot;

import com.sishiancode.springboot.dao.UserDao;
import com.sishiancode.springboot.dao.UserRepository;
import com.sishiancode.springboot.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringBoot02CrudApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {

		//User user = new  User("1007","aa@qq.com","13300001111","aaaa");
		//userDao.save(user);
		//userDao.getAll();
		List<User> users = userRepository.findAll();
		System.out.println(users.toString());
		//System.out.println(userDao.getAll().toString());
	}

}
