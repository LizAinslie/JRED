package me.railrunner16.jred.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class HttpClient {
	private static final String USER_AGENT = "RailHttp/1.0";

	public static String get(URL url, HashMap<String, String> headers) {
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);

			if (headers != null) headers.forEach(con::setRequestProperty);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) response.append(inputLine);
			in.close();

			return response.toString();
		} catch (Exception e) {
			return null;
		}
	}

	public static String get(String urlString, HashMap<String, String> headers) throws MalformedURLException {
		return get(new URL(urlString), headers);
	}

	public static String post(URL url, String body, HashMap<String, String> headers) {
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);

			if (headers != null) headers.forEach(con::setRequestProperty);

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(body);
			wr.flush();
			wr.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) response.append(inputLine);
			in.close();

			return response.toString();
		} catch (Exception e) {
			return null;
		}
	}

	public static String post(String urlString, String body, HashMap<String, String> headers) throws MalformedURLException {
		return post(new URL(urlString), body, headers);
	}
}
