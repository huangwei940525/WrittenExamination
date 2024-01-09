package com.refactor.practice;

/**
 * 普通片价格策略类
 */
public class RegularPrice implements PricePolicy{
    @Override
    public double getCharge(int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
