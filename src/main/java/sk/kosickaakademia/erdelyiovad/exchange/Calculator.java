package sk.kosickaakademia.erdelyiovad.exchange;

import sk.kosickaakademia.erdelyiovad.api.ApiRequest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

public class Calculator {

    private static final String[] rates = new String[]{"USD", "HUF", "CZK", "PLN", "BTC"};


    public void calculate(double eur) {

        if (eur < 0) {
            System.out.println("Input parameter can't be a negative value!!!");
            return;
        }

        HashSet<Object> set = new HashSet<>();
        Collections.addAll(set, rates);

        ApiRequest apiRequest = new ApiRequest();
        Map map = apiRequest.getExchangeRates(set);


        for (String temp : rates) {
            if (map.containsKey(temp)) {  //temp = shortcut for currency that we're converting
                double value = (double) map.get(temp);
                double result = eur * value;

                print("EUR", temp, eur, result, value);
            }

        }


    }

    private void print(String from, String to, double eur, double result, double rate) {
        System.out.println(eur + " " + from + " -> " + result + " " + to + " (exchange rate: " + rate + " )");


        }
    }

