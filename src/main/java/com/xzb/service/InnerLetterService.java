package com.xzb.service;

import java.util.List;

import com.xzb.pojo.InnerLetter;

public interface InnerLetterService {

	String Admin  = "管理员";
	//插入信件
	void add(InnerLetter inletter);

	//查询发给toperson的所有信
	List<InnerLetter> list(String toperson, int code);
    
	//查询通话记录
	List<InnerLetter> llistBoth(String person1, String person2);

	//根据id列表获取innerLetter
	List<InnerLetter> listById(List<Integer> list);

	//根据id删除站内信
	void delete(int letterId);
    //根据状态获取
	List<InnerLetter> llistBoth(String person1, String person2, int code);

	//根据id修改站内信状态
	void update(int letterId);
    //获取单向通信列表
	List<InnerLetter> getSingleLetters(String person1, String person2, int code);

	//通过id获取信件
	InnerLetter getById(int letterId);
}