package me.railrunner16.jred.oauth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TokenType {
	REFRESH("refresh_token"),
	ACCESS("access_token"),
	;

	private String typeString;
}
