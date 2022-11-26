class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int atln[][]=new int[n][m];
        int pacf[][]=new int[n][m];
        for(int i=0;i<n;i++){
            atln[i][m-1]=1;
            pacf[i][0]=1;
        }
        for(int j=0;j<m;j++){
            atln[n-1][j]=1;
            pacf[0][j]=1;
        }
        int vist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            fn(heights,atln,i,m-1);
            fn(heights,pacf,i,0);
        }
        for(int i=0;i<m;i++){
            fn(heights,atln,n-1,i);
            fn(heights,pacf,0,i);
        }
        List<List<Integer>>sol=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(atln[i][j]==1 && pacf[i][j]==1){
                    List<Integer>temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    sol.add(new ArrayList<Integer>(temp));
                }
            }
        }
        return sol;
        
    }
    void fn(int arr[][],int vist[][],int n,int m){
        Queue<Pair>q=new LinkedList<>();
        int dirt[][]={{0,1},{1,0},{-1,0},{0,-1}};
        vist[n][m]=1;
        q.add(new Pair(n,m));
        while(!q.isEmpty()){
            Pair p=q.remove();
            int num1=p.n;
            int num2=p.m;
            for(int i=0;i<dirt.length;i++){
                int putN=num1+dirt[i][0];
                int putM=num2+dirt[i][1];
                if(putN>=0 && putN<arr.length && putM>=0 && putM<arr[0].length){
                    if(vist[putN][putM]==0 && arr[putN][putM]>=arr[num1][num2]){
                        q.add(new Pair(putN,putM));
                        vist[putN][putM]=1;
                    }
                }
            }
        }
    }
}
class Pair{
    int n;
    int m;
    Pair(int n,int m){
        this.n=n;
        this.m=m;
    }
}