package myproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import twitter4j.Twitter;

public class TwitterExtractor {
	private static String AccessToken = "8xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxo";
	private static String AccessSecret = "sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxC";
	private static String ConsumerKey = "Uxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	private static String ConsumerSecret = "rxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

	private static HashMap authTokenMap = new HashMap();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		authTokenMap.put("AccessToken", AccessToken);
		authTokenMap.put("AccessSecret", AccessSecret);
		authTokenMap.put("ConsumerKey", ConsumerKey);
		authTokenMap.put("ConsumerSecret", ConsumerSecret);

		TwitterAuth twitterAuth = new TwitterAuth();
		TwitterData twitterData = new TwitterData();
		Twitter authObject = null;
		
		String topic = args[0];
		ArrayList tweets = new ArrayList();
		try {
			authObject = twitterAuth.authenticate(authTokenMap);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		try {
			tweets = twitterData.getTwitterData(authObject, topic);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("Tweets related to " + topic + " : " + tweets);

	}

}