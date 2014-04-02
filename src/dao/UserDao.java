package dao;

import model.User;

public interface UserDao {

	//跨数据库平台：面向抽象编程
	public void save(User user);
}
