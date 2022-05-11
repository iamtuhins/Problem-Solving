class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n=nums.size();
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int num=nums.get(i).get(0);
            Pair p=new Pair(i,0,num);
            pq.add(p);
            min=Math.min(num,min);
            max=Math.max(num,max);
        }
        int start=min;
        int end=max;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            min=p.val;
            if(end-start>max-min){
                start=min;
                end=max;
            }
            if(nums.get(p.li).size()>p.di+1){
                int tm=nums.get(p.li).get(p.di+1);
                max=Math.max(max,tm);
                p.val=tm;
                p.di=p.di+1;
                pq.add(p);
            }else{
                break;
            }
        }
        int sol[]=new int[2];
        sol[0]=start;
        sol[1]=end;
        return sol;
        
        
    }
}
class Pair implements Comparable<Pair>{
    int li;
    int di;
    int val;
    Pair(int li,int di,int val){
        this.li=li;
        this.di=di;
        this.val=val;
    }
    public int compareTo(Pair ob){
        return this.val-ob.val;
    }
    
}