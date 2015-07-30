package com.simpleStock;

import com.simpleStock.helper.ConsoleHelper;
import com.simpleStock.helper.InputHelper;
import com.simpleStock.model.Stock;
import com.simpleStock.model.Trade;
import com.simpleStock.model.TradeRecords;
import com.simpleStock.view.StockInput;
import com.simpleStock.view.TradeInput;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Dan on 29/07/2015.
 * Main application contain Sample StockRecord and TradeRecords
 */
public class SimpleStockApp {

    //Define memory stock
    private HashMap<String, Stock> stockRecord;
    private TradeRecords tradeRecords;

    //Define view
    private StockInput stockScreen;
    private TradeInput tradeScreen;

    /**
     * Default constructor
     */
    public SimpleStockApp() {
        this.stockRecord = new HashMap<>();
        this.tradeRecords = new TradeRecords();
        stockScreen = new StockInput(stockRecord);
        tradeScreen = new TradeInput(tradeRecords, stockRecord);
        this.buildStockRecord();
        this.buildTradeRecord();
    }

    /**
     * Start the application to interact with User
     * @throws IOException
     *         IOException throw form JVM, if JVM properly installed, this exception should never be thrown.
     */
    public void startApp() throws IOException {

        ConsoleHelper.print("Please Select the function:\n" +
                "1.calculate the dividend yield\n" +
                "2.calculate the P/E Ratio\n" +
                "3.Buy or sell stocks\n" +
                "4.Calculate Volume Weighted Stock Price(last 15 mins)\n" +
                "5.Calculate Geometric Mean of all stocks \n" +
                "6.Print recorded trade records \n" +
                "7. Quit Application\n");

        int actionSelect = InputHelper.validIntegerInput(ConsoleHelper.readLine("Please select your action:"), "Invalid input, please re-select action");

        while (actionSelect != 7) {
            switch (actionSelect) {
                case 1:
                    stockScreen.calculateDividendYield();
                    break;
                case 2:
                    stockScreen.calculatePERatio();
                    break;
                case 3:
                    tradeScreen.recordTrade();
                    break;
                case 4:
                    tradeScreen.calculateVWSP();
                    break;
                case 5:
                    tradeScreen.calGeoMean();
                    break;
                case 6:
                    tradeScreen.printTradeRecord();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Your input is invalid");
                    break;
            }
            actionSelect = Integer.parseInt(ConsoleHelper.readLine("Please select your action:"));
        }
    }

    /**
     * Initialise the Trade Records sample data.
     */
    private void buildTradeRecord() {
        Trade trade1 = new Trade("TEA","buy",1000,50, new Date(2015, 7, 29, 12, 22));
        tradeRecords.add(trade1);
        Trade trade2 = new Trade("TEA","buy",500,30, new Date(2015, 7, 30, 7, 22));
        tradeRecords.add(trade2);
        Trade trade3 = new Trade("TEA","buy",50,20, new Date(2015, 7, 30, 10, 45));
        tradeRecords.add(trade3);
        Trade trade4 = new Trade("TEA","buy",200,50, new Date(2015, 7, 30, 10, 47));
        tradeRecords.add(trade4);
        Trade trade11 = new Trade("GIN","buy",1000,50, new Date(2015, 7, 29, 12, 22));
        tradeRecords.add(trade11);
        Trade trade12 = new Trade("GIN","buy",500,30, new Date(2015, 7, 30, 7, 22));
        tradeRecords.add(trade12);
        Trade trade13 = new Trade("GIN","buy",50,20, new Date(2015, 7, 30, 10, 45));
        tradeRecords.add(trade13);
        Trade trade14 = new Trade("GIN","buy",200,50, new Date(2015, 7, 30, 10, 47));
        tradeRecords.add(trade14);
        Trade trade21 = new Trade("ALE","buy",1000,50, new Date(2015, 7, 29, 12, 22));
        tradeRecords.add(trade21);
        Trade trade22 = new Trade("ALE","buy",500,30, new Date(2015, 7, 30, 7, 22));
        tradeRecords.add(trade22);
        Trade trade23 = new Trade("ALE","buy",50,20, new Date(2015, 7, 30, 10, 55));
        tradeRecords.add(trade23);
        Trade trade24 = new Trade("ALE","buy",200,50, new Date(2015, 7, 30, 10, 57));
        tradeRecords.add(trade24);
        Trade trade31 = new Trade("POP","buy",1000,50, new Date(2015, 7, 29, 12, 22));
        tradeRecords.add(trade31);
        Trade trade32 = new Trade("POP","buy",500,30, new Date(2015, 7, 30, 7, 22));
        tradeRecords.add(trade32);
        Trade trade33 = new Trade("POP","buy",50,20, new Date(2015, 7, 30, 10, 55));
        tradeRecords.add(trade33);
        Trade trade34 = new Trade("POP","buy",200,50, new Date(2015, 7, 30, 10, 57));
        tradeRecords.add(trade34);
        Trade trade41 = new Trade("JOE","buy",1000,50, new Date(2015, 7, 29, 12, 22));
        tradeRecords.add(trade41);
        Trade trade42 = new Trade("JOE","buy",500,30, new Date(2015, 7, 30, 7, 22));
        tradeRecords.add(trade42);
        Trade trade43 = new Trade("JOE","buy",50,20, new Date(2015, 7, 30, 10, 55));
        tradeRecords.add(trade43);
        Trade trade44 = new Trade("JOE","buy",200,50, new Date(2015, 7, 30, 10, 57));
        tradeRecords.add(trade44);
    }

    /**
     * Initialise the Stock sample data based on Sample data from the Global Beverage Corporation Exchange in word document
     */
    private void buildStockRecord() {
        Stock stock0 = new Stock();
        stock0.setSymbol("TEA");
        stock0.setType("Common");
        stock0.setLastDividend(0);
        stock0.setFixedDividend(0);
        stock0.setParValue(100);
        stockRecord.put("TEA", stock0);

        Stock stock1 = new Stock();
        stock1.setSymbol("POP");
        stock1.setType("Common");
        stock1.setLastDividend(8);
        stock1.setFixedDividend(0);
        stock1.setParValue(100);
        stockRecord.put("POP", stock1);

        Stock stock2 = new Stock();
        stock2.setSymbol("ALE");
        stock2.setType("Common");
        stock2.setLastDividend(23);
        stock2.setFixedDividend(0);
        stock2.setParValue(60);
        stockRecord.put("ALE", stock2);

        Stock stock3 = new Stock();
        stock3.setSymbol("GIN");
        stock3.setType("Preferred");
        stock3.setLastDividend(8);
        stock3.setFixedDividend(0.02);
        stock3.setParValue(100);
        stockRecord.put("GIN", stock3);

        Stock stock4 = new Stock();
        stock4.setSymbol("JOE");
        stock4.setType("Common");
        stock4.setLastDividend(13);
        stock4.setFixedDividend(0);
        stock4.setParValue(250);
        stockRecord.put("JOE", stock4);
    }
}
