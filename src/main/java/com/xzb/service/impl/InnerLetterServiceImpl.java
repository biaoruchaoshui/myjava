package com.xzb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzb.mapper.InnerLetterMapper;
import com.xzb.pojo.InnerLetter;
import com.xzb.pojo.InnerLetterExample;
import com.xzb.service.InnerLetterService;

@Service
public class InnerLetterServiceImpl implements InnerLetterService {

	@Autowired
	InnerLetterMapper innerLetterMapper;

	@Override
	public void add(InnerLetter inletter) {
		// 插入站内信
		innerLetterMapper.insert(inletter);
	}

	@Override
	public List<InnerLetter> list(String toperson, int code) {
		// 查询发给用户的站内信
		InnerLetterExample example = new InnerLetterExample();
		example.createCriteria().andTopersonEqualTo(toperson).andLettercodeEqualTo(code);
		example.setOrderByClause("createtime desc");
		List<InnerLetter> list = innerLetterMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<InnerLetter> llistBoth(String person1, String person2) {
		// 查询通话记录,双方的，人1到人2 人2到人1
		InnerLetterExample example1 = new InnerLetterExample();
		InnerLetterExample example2 = new InnerLetterExample();
		example1.createCriteria().andFormpersonEqualTo(person1).andTopersonEqualTo(person2);
		example1.setOrderByClause("id asc");

		example2.createCriteria().andFormpersonEqualTo(person2).andTopersonEqualTo(person1);
		example2.setOrderByClause("id asc");
		List<InnerLetter> list1 = innerLetterMapper.selectByExample(example1);// 存储person1到person2的站内信集合
		List<InnerLetter> list2 = innerLetterMapper.selectByExample(example2); // 存储person2到person1的站内信集合
		List<Integer> listId = new ArrayList<Integer>();
		ArrayList<InnerLetter> listboth = new ArrayList<InnerLetter>();
		for (int i = 0; i < list1.size(); i++)
			System.out.println(list1.get(i));
		for (int j = 0; j < list2.size(); j++)
			System.out.println(list2.get(j));

		// 遍历两个list，将其合并到一个list集合后
		if (list1.size() == 0 || list2.size() == 0) {
			if (list1.size() > 0)
				return list1;
			else if (list2.size() > 0)
				return list2;
			else
				return null;
		}
		int a = 0;
		int b = 0;
		while (a < list1.size() || b < list2.size()) {
			if (a == list1.size()) {
				System.out.println("id" + list2.get(b).getId());
				listId.add(list2.get(b).getId());
				b++;
			} else if (b == list2.size()) {
				listId.add(list1.get(a).getId());
				a++;
			} else if (list1.get(a).getId() < list2.get(b).getId()) {
				listId.add(list1.get(a).getId());
				a++;
			} else {
				listId.add(list2.get(b).getId());
				b++;
			}
		}
		listboth = (ArrayList<InnerLetter>) listById(listId);
		return listboth;
	}

	@Override
	public List<InnerLetter> llistBoth(String person1, String person2, int code) {
		// 查询通话记录,根据状态
		InnerLetterExample example1 = new InnerLetterExample();
		InnerLetterExample example2 = new InnerLetterExample();
		example1.createCriteria().andFormpersonEqualTo(person1).andTopersonEqualTo(person2).andLettercodeEqualTo(code);
		example1.setOrderByClause("id asc");

		example2.createCriteria().andFormpersonEqualTo(person2).andTopersonEqualTo(person1).andLettercodeEqualTo(code);
		example2.setOrderByClause("id asc");
		List<InnerLetter> list1 = innerLetterMapper.selectByExample(example1);// 存储person1到person2的站内信集合
		List<InnerLetter> list2 = innerLetterMapper.selectByExample(example2); // 存储person2到person1的站内信集合
		List<Integer> listId = new ArrayList<Integer>();
		ArrayList<InnerLetter> listboth = new ArrayList<InnerLetter>();
		for (int i = 0; i < list1.size(); i++)
			System.out.println(list1.get(i));
		for (int j = 0; j < list2.size(); j++)
			System.out.println(list2.get(j));

		// 遍历两个list，将其合并到一个list集合后
		if (list1.size() == 0 || list2.size() == 0) {
			if (list1.size() > 0)
				return list1;
			else if (list2.size() > 0)
				return list2;
			else
				return null;
		}
		int a = 0;
		int b = 0;
		while (a < list1.size() || b < list2.size()) {
			if (a == list1.size()) {
				System.out.println("id" + list2.get(b).getId());
				listId.add(list2.get(b).getId());
				b++;
			} else if (b == list2.size()) {
				listId.add(list1.get(a).getId());
				a++;
			} else if (list1.get(a).getId() < list2.get(b).getId()) {
				listId.add(list1.get(a).getId());
				a++;
			} else {
				listId.add(list2.get(b).getId());
				b++;
			}
		}
		listboth = (ArrayList<InnerLetter>) listById(listId);
		return listboth;
	}

	@Override
	public List<InnerLetter> listById(List<Integer> list) {
		// 获取id列表获取站内信列表
		List<InnerLetter> listbyid = new ArrayList<InnerLetter>();
		for (int id : list) {
			InnerLetter inle = innerLetterMapper.selectByPrimaryKey(id);
			listbyid.add(inle);
		}
		return listbyid;
	}

	@Override
	public void update(int letterId) {
		// 根据id修改站内信
		InnerLetter letter = innerLetterMapper.selectByPrimaryKey(letterId);
		letter.setLettercode(1);
		innerLetterMapper.updateByPrimaryKey(letter);

	}

	@Override
	public void delete(int letterId) {
		// 根据id删除站内信
		innerLetterMapper.deleteByPrimaryKey(letterId);

	}

	@Override
	public List<InnerLetter> getSingleLetters(String person1, String person2, int code) {
		// 查询单项站内信列表
		InnerLetterExample example = new InnerLetterExample();
		example.createCriteria().andFormpersonEqualTo(person1).andTopersonEqualTo(person2).andLettercodeEqualTo(code);
		example.setOrderByClause("createtime desc");
		List<InnerLetter> list = innerLetterMapper.selectByExample(example);
		return list;

	}

	@Override
	public InnerLetter getById(int letterId) {
		//根据id获取信件
	   return innerLetterMapper.selectByPrimaryKey(letterId);
	}

}
