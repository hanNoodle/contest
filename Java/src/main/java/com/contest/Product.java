package com.contest;

import java.util.Calendar;
import java.util.Date;

public class Product extends Item {

	public Product(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	 private String name;

	 private int sellIn;

	 private int quality;
	 
	 private Date expireDate;//到期日

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSellIn() {
		return sellIn;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = getExpireDate (this.sellIn);
	}

	private Date getExpireDate (int sellIn) {
		 Calendar cd = Calendar.getInstance();
		 cd.add(Calendar.DATE, sellIn);
		 Date expireDate = cd.getTime();
		 return expireDate;
	}
}
