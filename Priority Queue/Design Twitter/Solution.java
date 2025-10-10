class Twitter {

    long time;
    Map<Integer,Set<Tweet>> tweetsMap;
    Map<Integer,Set<Integer>> followeeMap;

    public Twitter() {
        this.tweetsMap=new HashMap<>();
        this.followeeMap=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Set<Tweet> userTweets=tweetsMap.getOrDefault(userId,new HashSet<>());
        userTweets.add(new Tweet(tweetId,time++));
        tweetsMap.put(userId,userTweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq=new PriorityQueue<>(Comparator.comparing(Tweet::tweetTime));
        /* used min heap as every time we poll, oldest tweet in pq will be removed
            => finally most recent 10 will remain */

        if(followeeMap.containsKey(userId)) {
            for(int followeeId:followeeMap.get(userId)) { // followee's tweets
                if(tweetsMap.containsKey(followeeId)) {
                    for(Tweet tweet:tweetsMap.get(followeeId)) {
                        pq.add(tweet);
                        if(pq.size()>10) pq.poll();
                    }
                }
            }
        }

        if(tweetsMap.containsKey(userId)) {
            for(Tweet tweet:tweetsMap.get(userId)) { // self tweets
                pq.add(tweet);
                if(pq.size()>10) pq.poll();
            }
        }

        List<Integer> ans=new ArrayList<Integer>();
        Stack<Integer> feedTweets=new Stack<>(); // using stack to reverse order as we need most recent tweet first
        while(!pq.isEmpty()) feedTweets.push(pq.poll().tweetId);
        while(!feedTweets.isEmpty()) ans.add(feedTweets.pop());
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> userFollowees=followeeMap.getOrDefault(followerId,new HashSet<>());
        userFollowees.add(followeeId);
        followeeMap.put(followerId,userFollowees);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followeeMap.containsKey(followerId)) followeeMap.get(followerId).remove(followeeId);
    }
    
    class Tweet {
        int tweetId;
        long tweetTime;

        Tweet(int tweetId, long tweetTime) {
            this.tweetId=tweetId;
            this.tweetTime=tweetTime;
        }

        long tweetTime() {
            return this.tweetTime;
        }
    }
}