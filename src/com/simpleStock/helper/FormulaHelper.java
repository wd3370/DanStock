package com.simpleStock.helper;

import com.simpleStock.model.Trade;

import java.util.ArrayList;

/**
 * Created by Dan on 29/07/2015.
 * Collection of all fomulas used in this application
 */
public class FormulaHelper {

    /**
     * Calculate the Divident yield for common type stock
     * @param lastDivident
     *          lastDivident of stock
     * @param price
     *          market price of stock
     * @return
     *      Divident yield for this stock
     */
    public static double calculateCommonDividendYield(double lastDivident, double price) {

        return lastDivident / price;
    }

    /**
     * Calculate the Divident yield for preferred type stock
     * @param fixedDivident
     *          fixedDivident of stock
     * @param parValue
     *          par value of stock
     * @param price
     *          market price of stock
     * @return
     *      Divident yield for this stock
     */
    public static double calculatePreferredDividendYield(double fixedDivident, int parValue, double price) {

        return fixedDivident * parValue / price;
    }

    /**
     * Calculate the P/E ratio for a stock
     * @param dividend
     *          dividend of stock
     * @param price
     *         market price
     * @return
     *      P/E ratio for a stock
     */
    public static double calculatePERatio(double dividend,double price) {
        return price/dividend;
    }

    /**
     * Calculate Volume Weighted Stock Price based on trades
     * @param trades
     *          List of Trade
     * @return
     *         VWSP of Stock
     */
    public static double calculateVWSP(ArrayList<Trade> trades) {
        int quantity =0;
        double sumTradePrice=0;
        for(Trade trade : trades){
            sumTradePrice+=trade.getTradePrice()*trade.getShareQuantity();
            quantity+=trade.getShareQuantity();
        }
        return sumTradePrice/quantity;
    }
}
