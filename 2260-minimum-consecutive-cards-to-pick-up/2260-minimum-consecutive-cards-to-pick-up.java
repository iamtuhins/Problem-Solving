class Solution {
    public int minimumCardPickup(int[] cards) {
        int n=cards.length;
        Map<Integer,Integer>map=new HashMap<>();
        int temp=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(map.containsKey(cards[i])){
                int m=i-map.get(cards[i])+1;
                temp=Math.min(temp,m);
            }
            map.put(cards[i],i);
        }
        if(temp==Integer.MAX_VALUE){
            return -1;
        }
        int sol=temp;
        return sol;
        
    }
}