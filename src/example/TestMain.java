package example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	private BeanFactory factory;
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		TestMain u = (TestMain) factory.getBean("user");
		u.say();
	}
	private void say(){
		System.out.println("i am saying");
	}
}
