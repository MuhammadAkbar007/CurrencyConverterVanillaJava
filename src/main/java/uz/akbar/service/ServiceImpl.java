package uz.akbar.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import uz.akbar.model.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceImpl implements Service {

    public static double dollarPilot;
    public static double euroPilot;
    public static double roublePilot;

    private static double giveAmount() {
        System.out.print("Miqdorni kiriting: ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();

        if (amount > 0) {
            return amount;
        } else {
            return 0;
        }
    }

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String urlLink = "https://cbu.uz/uz/arkhiv-kursov-valyut/json/";
    Type type = new TypeToken<ArrayList<Currency>>() {
    }.getType();

    URL url;

    {
        try {
            url = new URL(urlLink);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            ArrayList<Currency> currencies = gson.fromJson(bufferedReader, type);
            currencies.forEach(currency -> {
                if (currency.getCcy().equals("USD")) {
                    dollarPilot = Double.parseDouble(currency.getRate());
                }
                if (currency.getCcy().equals("EUR")) {
                    euroPilot = Double.parseDouble(currency.getRate());
                }
                if (currency.getCcy().equals("RUB")) {
                    roublePilot = Double.parseDouble(currency.getRate());
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sumToDollar() {
        double amount = giveAmount();
        if (amount == 0) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Noto'g'ri summa miqdor kiritildi !");
        } else {
            System.out.println(amount + " so'm = " + (amount / dollarPilot) + " dollarga teng !");
        }
    }

    @Override
    public void sumToEuro() {
        double amount = giveAmount();
        if (amount == 0) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Noto'g'ri summa miqdor kiritildi !");
        } else {
            System.out.println(amount + " so'm = " + (amount / euroPilot) + " yevroga teng !");
        }
    }

    @Override
    public void sumToRouble() {
        double amount = giveAmount();
        if (amount == 0) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Noto'g'ri summa miqdor kiritildi !");
        } else {
            System.out.println(amount + " so'm = " + (amount / roublePilot) + " rublga teng !");
        }
    }
}
