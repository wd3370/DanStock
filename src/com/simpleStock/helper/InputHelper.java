package com.simpleStock.helper;

import com.simpleStock.model.Stock;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Dan on 30/07/2015.
 * Input helper class contain all common input for Integer input, Double input, Stock choose input etc.
 * all function will also force the user to re-input valid input if initial input is invalid.
 */
public class InputHelper {

    /**
     * Handle and validate Integer relative input.
     * @param s
     *      initialise input value of user.
     * @param reInputMsg
     *      re-input message if input is invalid
     * @return
     *        valid int value of input.
     * @throws IOException
     */
    public static int validIntegerInput(String s, String reInputMsg) throws IOException {
        int value = 0;
        while (value == 0) {
            try {
                value = Integer.parseInt(s);
            } catch (Exception e) {
                s = ConsoleHelper.readLine(reInputMsg);
            }
        }
        ConsoleHelper.print("\n");
        return value;
    }

    /**
     * Handle and validate double relative input.
     * @param s
     *      initialise input value of user.
     * @param reInputMsg
     *      re-input message if input is invalid
     * @return
     *        valid double value of input.
     * @throws IOException
     */
    public static double validDoubleInput(String s, String reInputMsg) throws IOException {
        double value = 0;

        while (value == 0) {
            try {
                value = Double.parseDouble(s);
            } catch (Exception e) {
                s = ConsoleHelper.readLine(reInputMsg);
            }
        }
        ConsoleHelper.print("\n");
        return value;
    }

    /**
     * Handle and validate Stock symbol relative input.
     * @param stockRecord
     *      stockRecord which contain all valid stocks
     * @param symbol
     *         initialise value of input value of user.
     * @param reInputMsg
     *      re-input message if input is invalid
     * @return
     *        valid int value of iput.
     * @throws IOException
     */
    public static String validStockSymbolInput(HashMap<String, Stock> stockRecord, String symbol, String reInputMsg) throws IOException {
        Stock selectedStock = stockRecord.get(symbol);
        while (selectedStock == null) {
            //Force user to input valid stock name
            symbol = ConsoleHelper.readLine(reInputMsg).toUpperCase();
            selectedStock = stockRecord.get(symbol);
        }
        ConsoleHelper.print("\n");
        return symbol;
    }
}
