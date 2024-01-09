package com.refactor.practice;

/**
 * 价格策略接口
 */
public interface PricePolicy {
    double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented);
}
