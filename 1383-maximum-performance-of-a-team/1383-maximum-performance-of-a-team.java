class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int engineers[][]=new int[n][2];
        for(int i=0;i<n;i++){
            engineers[i][0]=efficiency[i];
            engineers[i][1]=speed[i];
        }
        Arrays.sort(engineers,(p1,p2)->(p2[0]-p1[0]));
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        long sol=0;
        long speedOfSum=0;
        for(int i=0;i<n;i++){
            if(pq.size()>=k){
                speedOfSum-=pq.poll();
            }
            speedOfSum+=engineers[i][1];
            pq.add(engineers[i][1]);
            long temp=speedOfSum*engineers[i][0];
            if(temp>sol){
                sol=temp;
            }
        }
        return (int)(sol%1000000007);
        
        
    }
}