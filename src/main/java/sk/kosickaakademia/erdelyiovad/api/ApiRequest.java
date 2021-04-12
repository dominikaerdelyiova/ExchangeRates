package sk.kosickaakademia.erdelyiovad.api;

import jdk.internal.org.objectweb.asm.tree.InsnList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class ApiRequest {
    public Map getExchangeRates(HashSet<Object> rates){

        if(rates==null || rates.size() ==0)
            return null;

        return null;
    }
    public void getRatesFromAPIServer(){
      try {

        URL url = new URL("https://api.covid19api.com/summary");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Getting the response code
        int responsecode = conn.getResponseCode();

        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {

            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();

            //Using the JSON simple library parse the string into a json object
            JSONParser parse = new JSONParser();
            final JSONObject data_obj = (JSONObject) parse.parse(inline);

            //Get the required object from the above created object
            JSONObject obj = (JSONObject) data_obj.get("Global");

            //Get the required data using its key
            System.out.println(obj.get("TotalRecovered"));

            class JSONArray<arr> {
                arr= (JSONArray) data_obj.get("Countries");
            }

            InsnList arr;
            for (int i = 0; i < arr.size(); i++) {

                JSONObject new_obj = (JSONObject) arr.get(i);

                if (Objects.equals(new_obj.get("Slug"), "albania")) {
                    System.out.println("Total Recovered: " + new_obj.get("TotalRecovered"));
                    break;
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    class JSONObject {
        public boolean get(String global) {
        }
    }

      class JSONParser {
        public void parse(String inline) {
        }
    }

    class JSONArray {
        public void size() {
        }
    }
}

    private class JSONParser {
        public void parse(String inline) {
        }
    }

    private class JSONObject {
        public void get(String totalRecovered) {
        }
    }
}

