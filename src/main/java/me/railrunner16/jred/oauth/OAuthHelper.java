package me.railrunner16.jred.oauth;

import com.google.gson.Gson;
import me.railrunner16.jred.RedditClient;
import me.railrunner16.jred.http.BasicAuth;
import me.railrunner16.jred.http.FormBody;
import me.railrunner16.jred.http.HttpClient;

import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

public class OAuthHelper {
	private static class RedditGrantResponse {
		public String scope;
		public String access_token;
		public String token_type = "bearer";
		public long expires_in;
	}

	public static RedditClient automatic(Credentials credentials) {
		try {
			FormBody formBody = new FormBody();

			formBody.addElement("grant_type", "client_credentials");
			formBody.addElement("device_id", credentials.getDeviceId().toString());

			HashMap<String, String> headers = new HashMap<>();
			headers.put("Authorization", "Basic " + new BasicAuth(credentials.getClientId(), credentials.getClientSecret()).encode());

			String respJsonString = HttpClient.post("https://www.reddit.com/api/v1/access_token", formBody.toString(), headers);

			Gson gson = new Gson();
			RedditGrantResponse resp = gson.fromJson(respJsonString, RedditGrantResponse.class);

			return new RedditClient(resp.access_token, credentials);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean revokeToken(Credentials c, String token, TokenType type) {
		try {
			FormBody formBody = new FormBody();
			formBody.addElement("token", token);
			if (type != null) formBody.addElement("token_type_hint", type.getTypeString());

			HashMap<String, String> headers = new HashMap<>();
			headers.put("Authorization", "Basic " + new BasicAuth(c.getClientId(), c.getClientSecret()).encode());

			HttpClient.post("https://www.reddit.com/api/v1/revoke_token", formBody.toString(), headers);

			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
