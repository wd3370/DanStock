package com.simpleStock;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        SimpleStockApp simpleStockApp = new SimpleStockApp();
        try {
            simpleStockApp.startApp();
        } catch (IOException e) {
            System.err.println("Unexpected IOException from input, system is stop");
            e.printStackTrace();
        }
    }
}
