package com.xzb.service;

import java.util.List;

import com.xzb.pojo.FindStatement;

public interface FindStatementSerivce {

	void add(FindStatement findStatement);

	List<FindStatement> list();

	void fillUser(List<FindStatement> list);
}
