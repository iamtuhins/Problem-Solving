class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n=nums.size();
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int elem=nums.get(i).get(0);
            min=Math.min(min,elem);
            max=Math.max(max,elem);
            Pair p=new Pair(i,0,elem);
            pq.add(p);
        }
        
        int start=min;
        int ends=max;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            min=p.val;
            if(max-min<ends-start){
                ends=max;
                start=min;
            }
            if(p.data_id+1<nums.get(p.list_id).size()){
                int tm=nums.get(p.list_id).get(p.data_id+1);
                max=Math.max(max,tm);
                p.val=tm;
                p.data_id=p.data_id+1;
                pq.add(p);
            }else{
                break;
            }
        }
        int sol[]=new int[2];
        sol[0]=start;
        sol[1]=ends;
        return sol;
    }
}
class Pair implements Comparable<Pair>{
    int list_id;
    int data_id;
    int val;
    Pair(int list,int data,int val){
        this.list_id=list;
        this.data_id=data;
        this.val=val;
    }
    public int compareTo(Pair ob){
        return this.val-ob.val;
    }
}