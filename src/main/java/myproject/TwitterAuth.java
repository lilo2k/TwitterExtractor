package myproject;


import java.util.HashMap;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAuth {

	public Twitter authenticate(HashMap authTokenMap) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setJSONStoreEnabled(true);
		cb.setOAuthConsumerKey((String) authTokenMap.get("ConsumerKey"));
		cb.setOAuthConsumerSecret((String) authTokenMap.get("ConsumerSecret"));
		cb.setOAuthAccessToken((String) authTokenMap.get("AccessToken"));
		cb.setOAuthAccessTokenSecret((String) authTokenMap.get("AccessSecret"));
		cb.setHttpConnectionTimeout(100000);

		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		return twitter;
	}

}
