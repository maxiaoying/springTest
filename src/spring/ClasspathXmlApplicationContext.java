package spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;


/**
 * 模拟spring的功能
 * @author mxy
 *
 */
public class ClasspathXmlApplicationContext implements BeanFactory{

	private Map<String, Object> beans = new HashMap<String, Object>(); 
	
	public ClasspathXmlApplicationContext() throws Exception{
		SAXBuilder sb = new SAXBuilder();
		Document doc=sb.build(this.getClass().getClassLoader().getResourceAsStream("spring/beans.xml"));
		Element root=doc.getRootElement();
		List list =root.getChildren("bean");
		for (int i = 0; i < list.size(); i++) {
			//首先第一步一定要把所有的bean放入到容器中去，
			Element element =(Element)list.get(i);
			String id=element.getAttributeValue("id");
			String clazz =element.getAttributeValue("class");
			System.out.println(id+":"+clazz);
			Object o=Class.forName(clazz).newInstance();
			beans.put(id, o);
			//然后再去看哪个bean里有属性，然后把property拿出来
			for (Element proElement : (List<Element>)element.getChildren("property")) {
				String name=proElement.getAttributeValue("name");//拿到userDao
				String bean=proElement.getAttributeValue("bean");//拿到u
				Object beanObject =beans.get(bean);//UserDaoImpl instance
				String methodName="set" +name.substring(0,1).toUpperCase()+name.substring(1);
				System.out.println("method name = " + methodName);
				Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
				m.invoke(o, beanObject);
				
			}
		}
	}
	@Override
	public Object getBean(String name) {
		// TODO Auto-generated method stub
		return beans.get(name);
	}
	

}
