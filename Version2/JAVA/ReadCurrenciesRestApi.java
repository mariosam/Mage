/**
 * @version JAVA
 * @author MARIO SAM <eu@mariosam.com.br>
 * @see I would love to work with you: hire me!
 */
package JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReadCurrenciesRestApi {

    public static void main(String[] args) throws IOException {
        String site = "https://kriptonita.com.br";

        String[] ar = getCurrenciesWithREST( site );
        for (String moeda : ar) {
            System.out.println( "Moeda: " + moeda ); 
        }
	}

    /**
     * Simple example of REST API call to return all available currencies of Magento store.
     */
    public static String[] getCurrenciesWithREST(String site) {
        List<String> results = new ArrayList<String>();

        try {
            URL url = new URL(site + "/rest/V1/directory/currency");
            HttpURLConnection response = (HttpURLConnection) url.openConnection();

            if ( response.getResponseCode() == 200 ) {
                BufferedReader contents = new BufferedReader(new InputStreamReader(response.getInputStream()));
                String line = contents.readLine();

                if ( line.contains( "available_currency_codes" ) ) {
                    String[] currencies = line.substring( line.indexOf("available_currency_codes\":[") + 27, line.indexOf("]") ).split(",");

                    for (String currency : currencies) {
                        results.add( currency.replace('"', ' ').trim() );
                    }
                }
            }
            response.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return results.toArray(new String[results.size()]);
    }
}
