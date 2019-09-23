package me.railrunner16.jred.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Base64;

@Getter
@AllArgsConstructor
public class BasicAuth {
	private String username;
	private String password;

	public String encode() {
		return Base64.getEncoder().encodeToString((this.username + ":" + this.password).getBytes());
	}
}
