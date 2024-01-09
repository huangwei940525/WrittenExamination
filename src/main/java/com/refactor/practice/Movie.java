package com.refactor.practice;

/**
 * 电影类
 */
public class Movie {
	public static final int REGULAR = 0; // 普通片
	public static final int NEW_RELEASE = 1; // 新片
	public static final int CHILDRENS = 2; // 儿童片

	private String _title; // 电影名称
	private PricePolicy _price; // 价格策略

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public String getTitle() {
		return _title;
	}

	public int getPriceCode() {
		if (_price instanceof RegularPrice) { // 判断价格策略类型
			return Movie.REGULAR;
		} else if (_price instanceof NewReleasePrice) {
			return Movie.NEW_RELEASE;
		} else if (_price instanceof ChildrenPrice) {
			return Movie.CHILDRENS;
		}
		return -1; // or throw an exception
	}

	public void setPriceCode(int priceCode) {
		switch (priceCode) {
			case Movie.REGULAR:
				_price = new RegularPrice();
				break;
			case Movie.NEW_RELEASE:
				_price = new NewReleasePrice();
				break;
			case Movie.CHILDRENS:
				_price = new ChildrenPrice();
				break;
			default:
				throw new IllegalArgumentException("Invalid price code");
		}
	}

	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented); // 调用价格策略计算金额
	}

	public int getFrequentRenterPoints(int daysRented) {
		return _price.getFrequentRenterPoints(daysRented); // 调用价格策略计算积分
	}
}