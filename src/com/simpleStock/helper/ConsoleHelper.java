package com.simpleStock.helper;

import com.simpleStock.model.Stock;
import com.simpleStock.model.Trade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Dan on 30/07/2015.
 *
 * Sometimes, the Console is not available in some environment, we use Buffered reader to take a input
 */
public class ConsoleHelper {

    /**
     * Convenient function to print the message for user to input in Console and then return the value user input.
     * @param message
     *          Message show in console for user to input.
     * @param args
     *          Extra arguments
     * @return
     *          String value of user input
     * @throws IOException
     */
    public static String readLine(String message, Object... args) throws IOException {
        if (System.console() != null) {
            return System.console().readLine(message, args);
        }
        System.out.print(String.format(message, args));
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        return reader.readLine();
    }

    /**
     * Convenient function to print the message in console.
     * @param message
     *        message to be printed
     */
    public static void print(String message){
        if(System.console() != null){
            System.console().writer().println(message);
        } else {
            System.out.println(message);
        }
    }

    /**
     * Convenient function to print Stock detail in console.
     * @param stock
     *          Stock to be printed
     * @param df
     *          decimal formatter to format double only contain last two digits after the period
     */
    public static void printStock(Stock stock, DecimalFormat df){
        ConsoleHelper.print("Symbol: " + stock.getSymbol() +
                "\ttype: " + stock.getType() +
                "\tLast Dividend: " + df.format(stock.getLastDividend()) +
                "\tFixed Dividend:" + df.format(stock.getFixedDividend()) +
                "\tPar Value: " + stock.getParValue());
    }

    /**
     * Convenient function to print single trade detail in console.
     * @param trade
     *          trade record to be printed
     * @param df
     *          decimal formatter to format double only contain last two digits after the period
     * @param dateFormat
     *          formatter to format the date object into  "dd-M-yyyy hh:mm:ss" format
     */
    public static void printTrade(Trade trade, DecimalFormat df, SimpleDateFormat dateFormat){

        ConsoleHelper.print("Stock Symbol: " + trade.getStockSymbol() +
                        "\tindicator: " + trade.getIndicator() +
                        "\tTrade price: " + df.format(trade.getTradePrice()) +
                        "\tQuantity: " + trade.getShareQuantity() +
                        "\tTrade Date:" + dateFormat.format(trade.getTradeDate()));
    }
}
