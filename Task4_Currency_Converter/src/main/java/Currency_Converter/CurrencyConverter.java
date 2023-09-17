package Currency_Converter;

import java.util.Scanner;

public class CurrencyConverter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter base currency (e.g., USD): ");
			String baseCurrency = scanner.next().toUpperCase();

			System.out.print("Enter target currency (e.g., EUR): ");
			String targetCurrency = scanner.next().toUpperCase();

			double exchangeRates = ExchangeRate.getExchangeRate(baseCurrency, targetCurrency);

			if (exchangeRates == -1) {
				System.out.println("\nFailed to fetch exchange rates. Please check your inputs.");
				return;
			}

			System.out.print("\nEnter the amount to convert: ");
			double amount = scanner.nextDouble();

			double convertedAmount = amount * exchangeRates;

			System.out.print("\nConverted amount: " + convertedAmount + " " + targetCurrency);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
