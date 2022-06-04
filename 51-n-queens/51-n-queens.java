class Solution {
    public List<List<String>> solveNQueens(int n) {
      char arr[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        List<List<String>>sol=new ArrayList<>();
        fn(arr,0,n,sol);
        return sol;
        
    }
    void fn(char [][]arr,int colm,int n,List<List<String>>sol){
        if(colm==n){
            sol.add(new ArrayList<String>(construct(arr)));
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(i,colm,arr)){
                arr[i][colm]='Q';
                fn(arr,colm+1,n,sol);
                arr[i][colm]='.';
            }
        }
    }
    boolean isSafe(int row,int colm,char [][]arr){
        int n=row;
        int m=colm;
        while(row>=0 && colm>=0){
            if(arr[row][colm]=='Q'){
                return false;
            }
            row--;
            colm--;
        }
        row=n;
        colm=m;
        for(int i=colm;i>=0;i--){
            if(arr[row][colm]=='Q'){
                return false;
            }
            colm--;
        }
        row=n;
        colm=m;
        while(row<arr.length && colm>=0){
            if(arr[row][colm]=='Q'){
                return false;
            }
            row++;
            colm--;
        }
        return true;
    }
    List<String> construct(char [][]arr){
        List<String>temp=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            String st=new String(arr[i]);
            temp.add(st);
        }
        return temp;
    }
}