package com.xzb.pojo;

import java.util.Date;
import java.util.List;

public class Lost {
	private Integer id;

	private String name;

	private Date pickDate;

	private String pickperson;

	private String pickplace;

	private Integer code;

	private String claimperson;

	private Date claimdate;

	private Integer cid;

	// 非数据库字段
	private Category category;

	private LostImage firstLostImage;

	private LostImage detailLostImage;

	private List<LostImage> lostSingleImages;

	private List<LostImage> lostDetailImages;

	private int reviewCount;
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LostImage getFirstLostImage() {
		return firstLostImage;
	}

	public void setFirstLostImage(LostImage firstLostImage) {
		this.firstLostImage = firstLostImage;
	}

	public LostImage getDetailLostImage() {
		return detailLostImage;
	}

	public void setDetailLostImage(LostImage detailLostImage) {
		this.detailLostImage = detailLostImage;
	}

	public List<LostImage> getLostSingleImages() {
		return lostSingleImages;
	}

	public void setLostSingleImages(List<LostImage> lostSingleImages) {
		this.lostSingleImages = lostSingleImages;
	}

	public List<LostImage> getLostDetailImages() {
		return lostDetailImages;
	}

	public void setLostDetailImages(List<LostImage> lostDetailImages) {
		this.lostDetailImages = lostDetailImages;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
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

	public Date getPickDate() {
		return pickDate;
	}

	public void setPickDate(Date pickDate) {
		this.pickDate = pickDate;
	}

	public String getPickperson() {
		return pickperson;
	}

	public void setPickperson(String pickperson) {
		this.pickperson = pickperson == null ? null : pickperson.trim();
	}

	public String getPickplace() {
		return pickplace;
	}

	public void setPickplace(String pickplace) {
		this.pickplace = pickplace == null ? null : pickplace.trim();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getClaimperson() {
		return claimperson;
	}

	public void setClaimperson(String claimperson) {
		this.claimperson = claimperson == null ? null : claimperson.trim();
	}

	public Date getClaimdate() {
		return claimdate;
	}

	public void setClaimdate(Date claimdate) {
		this.claimdate = claimdate;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
}