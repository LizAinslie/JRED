package me.railrunner16.jred.http;

public class UserAgent {
	public String value;

	public UserAgent(String platform, String appId, String version, String redditUsername) {
		this.value = String.format("%s:%s:%s (by /u/%s)", platform, appId, version, redditUsername);
	}
}
