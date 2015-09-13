package com.example.termi_000.gamepractice;

/**
 * Created by termi_000 on 9/8/2015.
 */
public class DataStorage {

    private static String storedData = "";

    public static void setStoredData(String input) {
        storedData = input;
    }

    public static String getStoredData() {
        return storedData;
    }

}
