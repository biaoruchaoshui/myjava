package com.xzb.pojo;

import java.util.List;

public class Category {
    private Integer id;

    private String name;

    //以下为非数据库字段
    List<Lost> losts;    //分类下存储失物集合

    List<List<Lost>> lostByRow;//    //显示一行失物
    
    
    
    public List<Lost> getLosts() {
		return losts;
	}

	public void setLosts(List<Lost> losts) {
		this.losts = losts;
	}

	public List<List<Lost>> getLostByRow() {
		return lostByRow;
	}

	public void setLostByRow(List<List<Lost>> lostByRow) {
		this.lostByRow = lostByRow;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    //评论时匿名
    public String getAnonymousName(){
        if(null==name)
            return null;
 
        if(name.length()<=1)
            return "*";
 
        if(name.length()==2)
            return name.substring(0,1) +"*";
 
        char[] cs =name.toCharArray();
        for (int i = 1; i < cs.length-1; i++) {
            cs[i]='*';
        }
        return new String(cs);
 
    }
}