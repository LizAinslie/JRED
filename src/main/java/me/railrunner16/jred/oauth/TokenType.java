package me.railrunner16.jred.oauth;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * An API token's type.
 * @author RailRunner16
 */
@Getter
@AllArgsConstructor
public enum TokenType {
	REFRESH("refresh_token"),
	ACCESS("access_token"),
	;

	private String typeString;
}
