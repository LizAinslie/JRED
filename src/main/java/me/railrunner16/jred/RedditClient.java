package me.railrunner16.jred;

import lombok.Getter;
import me.railrunner16.jred.oauth.Credentials;
import me.railrunner16.jred.oauth.OAuthHelper;
import me.railrunner16.jred.oauth.TokenType;

public class RedditClient {
	private final String authToken;
	private final Credentials credentials;
	public final static String API_BASE = "https://oauth.reddit.com";

	public RedditClient(String authToken, Credentials credentials) {
		this.authToken = authToken;
		this.credentials = credentials;
	}

	public boolean revokeMyToken() {
		return OAuthHelper.revokeToken(this.credentials, this.authToken, TokenType.ACCESS);
	}
}
