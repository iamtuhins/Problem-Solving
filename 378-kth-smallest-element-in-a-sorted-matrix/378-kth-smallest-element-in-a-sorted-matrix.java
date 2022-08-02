class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(new Pair(matrix[i][0],i,0));
        }
        List<Integer>temp=new ArrayList<>();
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            temp.add(p.num);
            if(n>p.dtNum+1){
                Pair nm=new Pair(matrix[p.lNum][p.dtNum+1],p.lNum,p.dtNum+1);
                pq.add(nm);
            }
        }
        System.out.println(temp);
        int sol=temp.get(k-1);
        return sol;
        
        
    }
}
class Pair implements Comparable<Pair>{
    int num;
    int lNum;
    int dtNum;
    Pair(int n,int m,int j){
        this.num=n;
        this.lNum=m;
        this.dtNum=j;
    }
    public int compareTo(Pair obj){
        return this.num-obj.num;
    }
    
}