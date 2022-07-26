class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        List<Integer>nums=new ArrayList<>();
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(new Pair(matrix[i][0],i,0));
        }
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            nums.add(p.num);
            if(n>p.eNum+1){
                int id=p.eNum+1;
                Pair temp=new Pair(matrix[p.lNum][id],p.lNum,id);
                pq.add(temp);
            }
        }
        int sol=nums.get(k-1);
        return sol;
        
        
        
    }
}
class Pair implements Comparable<Pair>{
    int num;
    int lNum;
    int eNum;
    Pair(int n,int m,int p){
        this.num=n;
        this.lNum=m;
        this.eNum=p;
        
    }
    public int compareTo(Pair ob){
        return this.num-ob.num;
    }
}