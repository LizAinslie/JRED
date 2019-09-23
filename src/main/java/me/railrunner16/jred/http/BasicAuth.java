package me.railrunner16.jred.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Base64;

/**
 * Basic authorization data.
 * @author RailRunner16
 */
@Getter
@AllArgsConstructor
public class BasicAuth {
	private String username;
	private String password;

	/**
	 * Encode this username/password pair to base64.
	 * @return
	 */
	public String encode() {
		return Base64.getEncoder().encodeToString((this.username + ":" + this.password).getBytes());
	}

	/**
	 * Get the proper authorization header value for this authorization data.
	 * @return The proper auth header.
	 */
	public String header() {
		return "Basic " + this.encode();
	}
}
