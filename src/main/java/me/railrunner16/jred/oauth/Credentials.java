package me.railrunner16.jred.oauth;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Credentials {
	private AuthMethod method = null;
	private String clientId;
	private String clientSecret;
	private UUID deviceId = null;
	private String username = null;
	private String password = null;
	private String redirectUrl = null;

	public static Credentials userless(String clientId, String clientSecret, UUID deviceId) {
		return new Credentials(AuthMethod.USERLESS, clientId, clientSecret, deviceId, null, null, null);
	}

	public static Credentials script(String clientId, String clientSecret, String username, String password) {
		return new Credentials(AuthMethod.SCRIPT, clientId, clientSecret, null, username, password, null);
	}
}
