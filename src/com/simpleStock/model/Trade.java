package com.simpleStock.model;

import java.util.Date;

/**
 * Created by Dan on 29/07/2015.
 * Data model for single Trade record
 */
public class Trade {

    private String stockSymbol;
    private Date tradeDate;
    private int shareQuantity;
    private String indicator;
    private double tradePrice;

    public Trade(String stockName, String indicator, int quantity, double tradePrice) {
        this.stockSymbol = stockName;
        this.indicator = indicator;
        this.shareQuantity = quantity;
        this.tradePrice = tradePrice;
        //current date time;
        this.tradeDate = new Date();
    }

    public Trade(String stockName, String indicator, int quantity, double tradePrice, Date tradeDate) {
        this.stockSymbol = stockName;
        this.indicator = indicator;
        this.shareQuantity = quantity;
        this.tradePrice = tradePrice;
        //current date time;
        this.tradeDate = tradeDate;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public int getShareQuantity() {
        return shareQuantity;
    }

    public void setShareQuantity(int shareQuantity) {
        this.shareQuantity = shareQuantity;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public double getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }
}
