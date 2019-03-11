package com.contest;

import java.util.Calendar;
import java.util.Date;

public class ProductInfoUpdate {

	private static final String AGED_BRIE="Aged Brie";//法国干酪
	private static final String SULFURAS="Sulfuras";//游戏中的魔法锤道具
	private static final String BACKSTAGE_PASSES="Backstage passes";//剧场后台通行证
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 商品过期
	 */
	private void productExpire (Product product) {
		if (AGED_BRIE.equals(product.getName())) {
			agedBrieProUpdate (product);
		}else if (SULFURAS.equals(product.getName())) {
			
		}else if (BACKSTAGE_PASSES.equals(product.getName())) {
			backstagePassesUpdate (product);
		}else {
			normalProUpdate (product);
		}
	}
	
	/**
	 * 法国干酪信息更新
	 * @param item
	 */
	private void agedBrieProUpdate (Product product) {
		product.setQuality(product.getQuality()+1);
	}
	
	/**
	 * 游戏中的魔法锤道具信息更新
	 * @param item
	 */
	private void sulfurasUpdate (Product product) {
		//product.setQuality(product.getQuality()+1);
	}
	
	/**
	 * 剧场后台通行证信息更新
	 * @param item
	 */
	private void backstagePassesUpdate (Product product) {
		boolean flag = frontTenDay(product);
		if(flag) {
			product.setQuality(product.getQuality()+1);
		}
	}
	
	/**
	 * 普通商品信息更新
	 * @param item
	 */
	private void normalProUpdate (Product product) {
		product.setQuality(product.getQuality()-2);
	}
	
	/**
	 * 判断是否是前10天
	 * @param product
	 * @return
	 */
	private boolean frontTenDay (Product product) {
		boolean flag = false;
		int sellIn = product.getSellIn();
		Date nowDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -sellIn);
		Date startDate = cal.getTime();
		cal.add(Calendar.DATE, 10);
		Date endDate = cal.getTime();
		
		if (nowDate.getTime()>startDate.getTime() && nowDate.getTime()<endDate.getTime()) {
			flag = true;
		}
		return flag;
	}
}
