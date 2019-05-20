package com.xzb.service;

import com.xzb.pojo.Admin;

public interface AdminService {

	Admin get(String adminName, String password);
	
}
