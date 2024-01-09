package com.refactor.practice;

/**
 * 新片价格策略类
 */
public class NewReleasePrice implements PricePolicy{
    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
