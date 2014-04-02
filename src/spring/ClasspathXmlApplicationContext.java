package spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;


/**
 * ģ��spring�Ĺ���
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
			//���ȵ�һ��һ��Ҫ�����е�bean���뵽������ȥ��
			Element element =(Element)list.get(i);
			String id=element.getAttributeValue("id");
			String clazz =element.getAttributeValue("class");
			System.out.println(id+":"+clazz);
			Object o=Class.forName(clazz).newInstance();
			beans.put(id, o);
			//Ȼ����ȥ���ĸ�bean�������ԣ�Ȼ���property�ó���
			for (Element proElement : (List<Element>)element.getChildren("property")) {
				String name=proElement.getAttributeValue("name");//�õ�userDao
				String bean=proElement.getAttributeValue("bean");//�õ�u
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
