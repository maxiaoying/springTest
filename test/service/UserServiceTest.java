package service;

import model.User;

import org.junit.Test;

import spring.BeanFactory;
import spring.ClasspathXmlApplicationContext;

import dao.UserDao;

/**
 * @author mxy
 * junit���ԣ�һ���½�һ��Դ�ļ���test
 * ����Ҫ����service���е�add��������ʱ��src���е�service�µ����Ҽ�UserService�ļ����½�һ��junit test case����һ������ɣ�
 * ��ʱ����src��service��������һ����ΪUserServiceTest�ļ�����ʱ�����ļ���������½���Դ�ļ���test�£�
 * ��ʱ�ڴ��ļ��б�д���Լ���
 * 
 */
public class UserServiceTest {

	@Test  //ע�⣺��ʾ����һ�����Է�����
	public void testAdd() throws Exception{
		BeanFactory factory=new ClasspathXmlApplicationContext();
		//UserService service =new UserService();
		//UserDao userDao=(UserDao)factory.getBean("u");
		/**
		 * u�Ѿ�������xml�У�ֱ�Ӵ������ļ����ã�����springһ����Ҫ�Ĺ���
		 * ��ʱ��˼���ܲ���userserviceҲ����Ҫ����new����ֱ�Ӵ������ļ����ã����ֱ����xml�м�beanȻ���factory���ã�
		 * ��ʱ�ᱨ����ʾuserdaoû�г�ʼ����
		 * ��ʱspring��һ����Ҫ���ܾ��õ��ˣ�����ֱ���������ļ��н�dao��service�Ĺ�����ϵ�趨��
		 */
		UserService service =(UserService)factory.getBean("userService");
		User u =new User();
		service.add(u);
	}

}
