package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

public class UserService {

	/**
	 * 跨数据库平台实现：面向抽象编程（原来是写死的，无法更换的，面向抽象的好处就是灵活）
	 * 在service中new数据库的dao时new的是接口的实现，eg：private UserDao dao = new UserDaoImpl();
	 * 此时你可以多写几个dao的实现类，需要用哪个选即可。
	 * 
	 */
	private UserDao dao = new UserDaoImpl();//该步可放在配置文件中灵活使用
    public void add(User user) {
		dao.save(user);//new的谁的dao，就调用谁的方法！
	}
    
    
    
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
    
}
