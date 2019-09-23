package me.railrunner16.jred;

import lombok.Getter;
import me.railrunner16.jred.oauth.Credentials;
import me.railrunner16.jred.oauth.OAuthHelper;
import me.railrunner16.jred.oauth.TokenType;

/**
 * A Reddit API client.
 * @author RailRunner16
 */
public class RedditClient {
	private final String authToken;
	@Getter private final Credentials credentials;
	public final static String API_BASE = "https://oauth.reddit.com";

	/**
	 * Create a new Reddit client.
	 * @param authToken The authorization token used to access the api with.
	 * @param credentials The original credentials that can be used to perform actions such as revoking a token.
	 */
	public RedditClient(String authToken, Credentials credentials) {
		this.authToken = authToken;
		this.credentials = credentials;
	}

	/**
	 * Revoke the current access token.
	 * @return Whether or not the operation was successful.
	 */
	public boolean revokeMyToken() {
		return OAuthHelper.revokeToken(this.credentials, this.authToken, TokenType.ACCESS);
	}
}
