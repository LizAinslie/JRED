package me.railrunner16.jred.oauth;

import com.google.gson.Gson;
import me.railrunner16.jred.RedditClient;
import me.railrunner16.jred.http.BasicAuth;
import me.railrunner16.jred.http.FormBody;
import me.railrunner16.jred.http.HttpClient;

import java.util.HashMap;

/**
 * An OAuth helper class.
 * @author RailRunner16
 */
public class OAuthHelper {
	private static class RedditGrantResponse {
		public String scope;
		String access_token;
		public String token_type = "bearer";
		public long expires_in;
	}

	/**
	 * Create a new Reddit API client from the given credentials.
	 * @param credentials The credentials to use in order to create the API client.
	 * @return The new API client.
	 */
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

	/**
	 * Revoke a token.
	 * @param c The credentials of the app that the token belongs to.
	 * @param token The token to revoke.
	 * @param type The type of token to revoke.
	 * @return Whether or not the action was successful.
	 */
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

	/**
	 * Revoke a token of an unknown type. This method will take longer, as Reddi has to guess at the type of token to revoke.
	 * @param c The credentials of the app that the token belongs to.
	 * @param token The token to revoke.
	 * @return Whether or not the action was successful.
	 */
	public static boolean revokeToken(Credentials c, String token) {
		return revokeToken(c, token, null);
	}
}
