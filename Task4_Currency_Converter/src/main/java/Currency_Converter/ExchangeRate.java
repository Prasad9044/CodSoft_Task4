package Currency_Converter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class ExchangeRate {
	static double getExchangeRate(String baseCurrency, String targetCurrency) {
		try {
			String apiKey = "3a0acfdc8ca44da88e1f5254651f17b3";
			URL url = new URL("http://openexchangerates.org/api/latest.json?app_id=" + apiKey);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			if (connection.getResponseCode() == 200) {
				Scanner scanner = new Scanner(connection.getInputStream());
				StringBuilder response = new StringBuilder();

				while (scanner.hasNextLine()) {
					response.append(scanner.nextLine());
				}
				try {
					JSONObject jsonResponse = new JSONObject(response.toString());
					return jsonResponse.getJSONObject("rates").getDouble(targetCurrency);
				} catch (Exception e) {
				}
			}
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
