package service;

import model.User;

import org.junit.Test;

import spring.BeanFactory;
import spring.ClasspathXmlApplicationContext;

import dao.UserDao;

/**
 * @author mxy
 * junit测试：一般新建一个源文件包test
 * 假如要测试service包中的add方法，此时在src包中的service下单击右键UserService文件，新建一个junit test case，下一步，完成；
 * 此时会在src的service包中生成一个名为UserServiceTest文件，此时将该文件拖至最初新建的源文件包test下；
 * 此时在此文件中编写测试即可
 * 
 */
public class UserServiceTest {

	@Test  //注解：表示这是一个测试方法，
	public void testAdd() throws Exception{
		BeanFactory factory=new ClasspathXmlApplicationContext();
		//UserService service =new UserService();
		//UserDao userDao=(UserDao)factory.getBean("u");
		/**
		 * u已经配置在xml中，直接从配置文件中拿，这是spring一个重要的功能
		 * 此时，思考能不能userservice也不不要我们new而是直接从配置文件中拿：如果直接在xml中加bean然后从factory中拿，
		 * 此时会报错，提示userdao没有初始化。
		 * 此时spring另一个重要功能就用到了：可以直接在配置文件中将dao和service的关联关系设定好
		 */
		UserService service =(UserService)factory.getBean("userService");
		User u =new User();
		service.add(u);
	}

}
