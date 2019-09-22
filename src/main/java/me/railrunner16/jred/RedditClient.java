package me.railrunner16.jred;

import lombok.Getter;

public class RedditClient {
	private final String authToken;
//	public final static String API_BASE = "";

	public RedditClient(String authToken) {
		this.authToken = authToken;
	}
}
