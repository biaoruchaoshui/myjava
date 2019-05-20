package com.xzb.service;

import java.util.List;

import com.xzb.pojo.Review;

public interface ReviewService {

	 void add(Review c);
	 
	    void delete(int id);
	    void update(Review c);
	    Review get(int id);
	    List list(int lid);
	 
	    int getCount(int lid);
}
