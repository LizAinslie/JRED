package me.railrunner16.jraw.oauth;

import me.railrunner16.jred.RedditClient;
import me.railrunner16.jred.oauth.Credentials;
import me.railrunner16.jred.oauth.OAuthHelper;
import org.junit.Test;

import java.util.UUID;

public class OAuthHelperTest {
	@Test
	public void automatic_test_1() {
		Credentials c = Credentials.userless("l0jvYFX2GSG_lA", "Bbiuh8OQxuoutpGpkdw-pSQ4HfI", UUID.randomUUID());
		RedditClient client = OAuthHelper.automatic(c);
	}
}
