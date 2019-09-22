package me.railrunner16.jred.oauth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthMethod {
	WEBAPP(false),
	SCRIPT(false),
	APP(false),
	USERLESS(true),
	USERLESS_APP(true),
	;

	private boolean userless;
}
