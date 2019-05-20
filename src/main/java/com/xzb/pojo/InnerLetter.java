package com.xzb.pojo;

import java.util.Date;

public class InnerLetter {
    private Integer id;

    private String formperson;

    private String toperson;

    private String content;

    private Date createtime;

    private Integer lettercode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFormperson() {
        return formperson;
    }

    public void setFormperson(String formperson) {
        this.formperson = formperson == null ? null : formperson.trim();
    }

    public String getToperson() {
        return toperson;
    }

    public void setToperson(String toperson) {
        this.toperson = toperson == null ? null : toperson.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getLettercode() {
        return lettercode;
    }

    public void setLettercode(Integer lettercode) {
        this.lettercode = lettercode;
    }

	@Override
	public String toString() {
		return "InnerLetter [id=" + id + ", formperson=" + formperson + ", toperson=" + toperson + ", content="
				+ content + ", createtime=" + createtime + ", lettercode=" + lettercode + "]";
	}
    
}