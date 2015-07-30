package com.simpleStock.action;

import com.simpleStock.helper.FormulaHelper;
import com.simpleStock.model.Stock;
import com.simpleStock.model.Trade;
import com.simpleStock.model.TradeRecords;

import java.util.*;

/**
 * Created by Dan on 29/07/2015.
 * Trade Action to handle all logic of action.
 */
public class TradeRecordAction {

    //Define variable
    private TradeRecords tradeRecords;
    private HashMap<String, Stock> stockRecord;

    /**
     * Default Constructor
     *
     * @param tradeRecords sample trade records
     * @param stockRecord  sample stock records
     */
    public TradeRecordAction(TradeRecords tradeRecords, HashMap<String, Stock> stockRecord) {
        this.tradeRecords = tradeRecords;
        this.stockRecord = stockRecord;
    }

    /**
     * action handler for calculate VWSP
     *
     * @param stockSymbol stock symbol
     * @return VWSP value of stock
     */
    public double calculateVWSP(String stockSymbol) {

        Date dataNow = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataNow);
        //Set startDate is 15 minutes before.
        cal.add(Calendar.MINUTE, -15);
        Date startDate = cal.getTime();
        ArrayList<Trade> trades = new ArrayList<>();
        for (Trade trade : tradeRecords) {
            //Check the tradeDate is after that startDate
            if (trade.getTradeDate().after(startDate) && trade.getStockSymbol().equals(stockSymbol)) {
                trades.add(trade);
            }
        }
        if (trades.size() > 0) {
            return FormulaHelper.calculateVWSP(trades);
        } else {
            return 0;
        }
    }

    /**
     * Action  handler for calculate the geometric mean
     *
     * @return the geometric mean value
     */
    public double calGeoMean() {

        double mulPrice = 1;
        int count = 0;
        Set<String> symbolSet = stockRecord.keySet();
        for (String symbol : symbolSet) {
            double vwsp = this.calculateVWSP(symbol);
            mulPrice = mulPrice * vwsp;
            count++;
        }
        return Math.pow(mulPrice, 1d / count);
    }

    //Setter and getter
    public void recordTrade(Trade trade) {
        this.tradeRecords.add(trade);
    }

    public TradeRecords getTradeRecords() {
        return tradeRecords;
    }

    public void setTradeRecords(TradeRecords tradeRecords) {
        this.tradeRecords = tradeRecords;
    }

    public HashMap<String, Stock> getStockRecord() {
        return stockRecord;
    }

    public void setStockRecord(HashMap<String, Stock> stockRecord) {
        this.stockRecord = stockRecord;
    }
}
