class Twitter {
    HashMap<Integer,LinkedList<Integer>> users;
    PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->b[0]-a[0]);
    HashMap<Integer,HashSet<Integer>> follow;
    int time;
    public Twitter() {
        this.follow=new HashMap();
        this.time=0;
    }
    public void postTweet(int userId, int tweetId) {
        if(follow.get(userId)==null){
            follow.put(userId,new HashSet());
        }
        pq.add(new int[]{time++,userId,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list=new LinkedList();
        PriorityQueue<int[]> pq1=new PriorityQueue<int[]>((a,b)->b[0]-a[0]);
        int i=0;
        while(!pq.isEmpty() && i<10){
            int[] arr=pq.poll(); 
            if(follow.get(userId).contains(arr[1]) || userId==arr[1]){
                list.add(arr[2]);i++;
            }
            pq1.add(arr);
        }
        while(!pq1.isEmpty()){
            pq.add(pq1.poll());
        }
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        if(follow.get(followerId)!=null)
            follow.get(followerId).add(followeeId);
        else{
            follow.put(followerId,new HashSet());
            follow.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follow.get(followerId)!=null)
            follow.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */