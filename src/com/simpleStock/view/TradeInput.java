package com.simpleStock.view;

import com.simpleStock.action.TradeRecordAction;
import com.simpleStock.helper.ConsoleHelper;
import com.simpleStock.helper.InputHelper;
import com.simpleStock.model.Stock;
import com.simpleStock.model.Trade;
import com.simpleStock.model.TradeRecords;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * Created by Dan on 30/07/2015.
 * Console screen view relative to Trade relative interaction.
 */
public class TradeInput {

    private TradeRecordAction tradeRecordsAction;

    /**
     * Default constuctor
     * @param tradeRecords
     *          Sample tradeRecords from main application
     * @param stockRecord
     *          Sample Stock records from main application
     */
    public TradeInput(TradeRecords tradeRecords, HashMap<String, Stock> stockRecord) {
        this.tradeRecordsAction = new TradeRecordAction(tradeRecords, stockRecord);
    }

    /**
     * Console interaction for action 3: Record trade operation.
     * @throws IOException
     */
    public void recordTrade() throws IOException {
        //Use to format double and time
        DecimalFormat df = new DecimalFormat("####0.00");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        HashMap<String, Stock> stockRecord =  tradeRecordsAction.getStockRecord();

        //Enter buy or sell
        String indicator = ConsoleHelper.readLine("Please enter 'buy' or 'sell':").toLowerCase();
        while (("buy").equals(indicator) == false && ("sell").equals(indicator) == false) {
            indicator = ConsoleHelper.readLine("invalid input, Please enter 'buy' or 'sell':").toLowerCase();
        }
        ConsoleHelper.print("\n");

        ConsoleHelper.print("You can choose from following Stock:");
        for (Stock stock :stockRecord.values()) {
            ConsoleHelper.printStock(stock,df);
        }
        ConsoleHelper.print("\n");

        //select stock
        String stockName = InputHelper.validStockSymbolInput(stockRecord,
                ConsoleHelper.readLine("Please input stock symbol you choose:").toUpperCase(),
                "Stock Symbol is invalid, Please re-input your Stock Symbol:");

        //quantity of shares
        int quantity = InputHelper.validIntegerInput(ConsoleHelper.readLine("How many stocks you want to " + indicator + ":"), "Invalid input, Please re-enter how many stocks you want to " + indicator + ":");

        //Trade price
        double tradePrice = InputHelper.validDoubleInput(ConsoleHelper.readLine("Enter your trade price:"), "Invalid input, Please re-enter your trade price:");

        //Create trade and record it.
        Trade trade = new Trade(stockName,indicator,quantity,tradePrice);
        tradeRecordsAction.recordTrade(trade);

        ConsoleHelper.print("Your trade record has been saved successfully, following is your trade record detail:");
        ConsoleHelper.printTrade(trade,df,dateFormat);

    }

    /**
     * Console interaction for action 6: Print all Trade record.
     * @throws IOException
     */
    public void printTradeRecord() {
        //Use to format double and time
        DecimalFormat df = new DecimalFormat("####0.00");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        TradeRecords records = tradeRecordsAction.getTradeRecords();

        if(records.size() == 0){
            ConsoleHelper.print("Trade records are empty");
        }
        ConsoleHelper.print("Following are all trade records:");
        for (Trade trade: records){
            ConsoleHelper.printTrade(trade, df, dateFormat);
        }
        ConsoleHelper.print("\n");
    }

    /**
     * Console interaction for action 4: calculate Volume Weighted Stock Price.
     * @throws IOException
     */
    public void calculateVWSP() throws IOException {
        DecimalFormat df = new DecimalFormat("####0.00");
        HashMap<String, Stock> stockRecord = tradeRecordsAction.getStockRecord();
        //Choose stock
        ConsoleHelper.print("You can choose from following Stock:");
        for (Stock stock : stockRecord.values()) {
            ConsoleHelper.printStock(stock, df);
        }
        //Input Stock symbol
        String stockName = InputHelper.validStockSymbolInput(stockRecord,
                ConsoleHelper.readLine("Please input stock symbol you choose:").toUpperCase(),
                "Stock Symbol is invalid, Please re-input your Stock Symbol:");

        ConsoleHelper.print("The Volume Weighted Stock Price for Stock "+ stockName + " in last 15 mins is " + df.format(tradeRecordsAction.calculateVWSP(stockName)));
        ConsoleHelper.print("\n");
    }

    /**
     * Console interaction for action 5: calculate geometric mean of prices
     * @throws IOException
     */
    public void calGeoMean() {
        DecimalFormat df = new DecimalFormat("####0.00");
        ConsoleHelper.print("The Geometric Mean of all stocks is " + df.format(tradeRecordsAction.calGeoMean()));
        ConsoleHelper.print("\n");
    }
}
