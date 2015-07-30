package com.simpleStock.view;

import com.simpleStock.action.StockAction;
import com.simpleStock.helper.ConsoleHelper;
import com.simpleStock.helper.InputHelper;
import com.simpleStock.model.Stock;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * Created by Dan on 30/07/2015.
 * Console screen view relative to Stock relative interaction.
 */
public class StockInput {

    private StockAction stockAction;

    /**
     * Default Constructor
     * @param stockRecord
     *      Sample stockRecord from application
     */
    public StockInput(HashMap<String, Stock> stockRecord) {
        this.stockAction = new StockAction(stockRecord);
    }

    /**
     * Console interaction for action 1: Calculate Divident Yield
     * @throws IOException
     */
    public void calculateDividendYield() throws IOException {
        //Use to format double
        DecimalFormat df = new DecimalFormat("####0.00");
        HashMap<String, Stock> stockRecord = stockAction.getStockRecord();
        //Choose stock
        ConsoleHelper.print("You can choose from following Stock:");
        for (Stock stock : stockRecord.values()) {
            ConsoleHelper.printStock(stock, df);
        }

        //Input Stock symbol
        String stockName = InputHelper.validStockSymbolInput(stockRecord,
                ConsoleHelper.readLine("Please input stock symbol you choose:").toUpperCase(),
                "Stock Symbol is invalid, Please re-input your Stock Symbol:");

        //Input price
        double dPrice = InputHelper.validDoubleInput(ConsoleHelper.readLine("Please input market price:"), "Invalid input, Please input a valid market price");

        //output
        ConsoleHelper.print("The Dividend Yield for Stock:" + stockName + " is " + df.format(stockAction.calculateDividendYield(stockRecord.get(stockName), dPrice)));
        ConsoleHelper.print("\n");
    }


    /**
     * Console interaction for action 2: Calculate the P/E Ratio for stock
     * @throws IOException
     */
    public void calculatePERatio() throws IOException {
        //Use to format double
        DecimalFormat df = new DecimalFormat("####0.00");
        HashMap<String, Stock> stockRecord = stockAction.getStockRecord();
        //Choose stock
        ConsoleHelper.print("You can choose from following Stock:");
        for (Stock stock : stockRecord.values()) {
            ConsoleHelper.printStock(stock, df);
        }

        //Input Stock symbol
        String stockName = InputHelper.validStockSymbolInput(stockRecord,
                ConsoleHelper.readLine("Please input stock symbol you choose:").toUpperCase(),
                "Stock Symbol is invalid, Please re-input your Stock Symbol:");

        //Check lastDividend is valid for calculation, Sample Stock "DEA" has last dividend of 0 which is invalid for divide function.
        while(stockRecord.get(stockName).getLastDividend()==0) {
            ConsoleHelper.print("The Stock has 0 stock dividend which cannot be uesed in the formular!");
            stockName = InputHelper.validStockSymbolInput(stockRecord,
                    ConsoleHelper.readLine("Please re-input stock symbol you choose:").toUpperCase(),
                    "Stock Symbol is invalid, Please re-input your Stock Symbol:");
        }
        //Input price
        double dPrice = InputHelper.validDoubleInput(ConsoleHelper.readLine("Please input market price:"), "Invalid input, Please input a valid market price");

        //output
        ConsoleHelper.print("The PE Radio for Stock:" + stockName + " is " + df.format(stockAction.calculatePERatio(stockRecord.get(stockName), dPrice)));
        ConsoleHelper.print("\n");
    }


}
