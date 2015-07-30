package com.simpleStock.action;

import com.simpleStock.helper.FormulaHelper;
import com.simpleStock.model.Stock;

import java.util.HashMap;

/**
 * Created by Dan on 29/07/2015.
 * Stock Action to handle all logic of action.
 */
public class StockAction {
    //define variable
    HashMap<String, Stock> stockRecord;

    /**
     * Default Constructor
     * @param stockRecord
     *         sample stock records from application
     */
    public StockAction(HashMap<String, Stock> stockRecord) {
        this.stockRecord = stockRecord;
    }

    /**
     * Action handler for Calculate Dividend yield of stock
     * @param stock
     *         Stock has been selected
     * @param price
     *       market price of stock
     * @return
     *      dividend yield of stock
     */
    public double calculateDividendYield(Stock stock, double price) {
        double result=0;
        if(stock.getType().equals("Common")) {
            result= FormulaHelper.calculateCommonDividendYield(stock.getLastDividend(), price);
        }else if(stock.getType().equals("Preferred")) {
            result = FormulaHelper.calculatePreferredDividendYield(stock.getFixedDividend(), stock.getParValue(), price);
        }
        return result;
    }

    /**
     * action handler of calculating P/E ratio of stock
     * @param stock
     *      Stock being selected
     * @param price
     *      market price
     * @return
     *      P/E ratio
     */
    public double calculatePERatio(Stock stock, double price) {
        return FormulaHelper.calculatePERatio(stock.getLastDividend(), price);
    }

     //Setter and getter
    public HashMap<String, Stock> getStockRecord() {
        return stockRecord;
    }

    public void setStockRecord(HashMap<String, Stock> stockRecord) {
        this.stockRecord = stockRecord;
    }
}
