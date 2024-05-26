package Heaps;

import java.util.*;

public class Design_Twitter {
    static int time;
    static Map<Integer, Set<Integer>> following;
    static Map<Integer, List<Info>> tweets;

    Design_Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        time++;
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Info(userId, tweetId, time));

        following.putIfAbsent(userId, new HashSet<>());
        following.get(userId).add(userId); // Ensure the user follows themselves
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> posts = new ArrayList<>();
        if (!following.containsKey(userId)) {
            return posts;
        }

        PriorityQueue<Info> feed = new PriorityQueue<>((a, b) -> b.time - a.time);
        Set<Integer> followees = following.get(userId);

        for (int followeeId : followees) {
            if (tweets.containsKey(followeeId)) {
                List<Info> followeeTweets = tweets.get(followeeId);
                for (Info tweet : followeeTweets) {
                    feed.offer(tweet);
                }
            }
        }

        int count = 0;
        while (!feed.isEmpty() && count < 10) {
            posts.add(feed.poll().postId);
            count++;
        }

        return posts;
    }

    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId) && followerId != followeeId) {
            following.get(followerId).remove(followeeId);
        }
    }
}

class Info {
    int userId;
    int postId;
    int time;

    Info(int userId, int postId, int time) {
        this.userId = userId;
        this.postId = postId;
        this.time = time;
    }
}