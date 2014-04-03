package service;



import model.User;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.UserService;

public class UserServiceTest {

	@Test
	public void testAdd() {
		//�����ҵ�beans.xml.���Լ��ض�������ļ�
			ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
			UserService service = (UserService)appContext.getBean("userService");
			User user= new User();
			user.setUsername("zhangsan");
			user.setPassword("zhangsan");
			service.add(user);
	}

}
