package myproject;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
public class TwitterData {

	public ArrayList getTwitterData(Twitter authObject, String topic) {
		System.out.println("Inside tweet data method: "+authObject + " , "+topic);
		ArrayList tweetList = new ArrayList();
		try {
            Query query = new Query(topic);
            /**
             * filtering
             */
            query.setLang("en");
            query.setSince("2020-01-01");
            query.setUntil("2020-02-01");
			QueryResult result = null;
			do {
				result = authObject.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
					tweetList.add(tweet.getText());
					/**
					 * creating a dataset
					 */
					System.out.println(tweet.getCreatedAt() + " " + tweet.getText());
				}
			} while (result.hasNext() == true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Failed to search tweets: " + e.getMessage());
		}
		System.out.println(tweetList);
		return tweetList;
	}

}
