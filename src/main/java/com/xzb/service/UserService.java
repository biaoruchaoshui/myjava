package com.xzb.service;

import java.util.List;

import com.xzb.pojo.User;
//用户管理service层
public interface UserService {

	void add(User c);
	void delete(int id);
	void update(User c);
    User get(int id);
    List list();
    boolean isExist(String name);
    User get(String name, String password);
}
