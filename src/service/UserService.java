package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserService {

	/**
	 * �����ݿ�ƽ̨ʵ�֣���������̣�ԭ����д���ģ��޷������ģ��������ĺô�������
	 * ��service��new���ݿ��daoʱnew���ǽӿڵ�ʵ�֣�eg��private UserDao dao = new UserDaoImpl();
	 * ��ʱ����Զ�д����dao��ʵ���࣬��Ҫ���ĸ�ѡ���ɡ�
	 * 
	 */
	private UserDao dao = new UserDaoImpl();//�ò��ɷ��������ļ������ʹ��
    public void add(User user) {
		dao.save(user);//new��˭��dao���͵���˭�ķ�����
	}
    
    
    
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
    
}
