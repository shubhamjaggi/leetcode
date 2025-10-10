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
        tweetsMap.putIfAbsent(userId,new HashSet<>());
        tweetsMap.get(userId).add(new Tweet(tweetId,time++));
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
        while(!pq.isEmpty()) ans.add(pq.poll().tweetId);
        Collections.reverse(ans); return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        followeeMap.putIfAbsent(followerId,new HashSet<>());
        followeeMap.get(followerId).add(followeeId);
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