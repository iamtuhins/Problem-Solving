class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            fn(board,i,0);
            fn(board,i,m-1);
        }
        for(int j=0;j<m;j++){
            fn(board,0,j);
            fn(board,n-1,j);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        
    }
    void fn(char [][]board,int i,int j){
        if(i<0|| i>=board.length||  j<0|| j>=board[0].length
          || board[i][j]=='T' || board[i][j]=='X'){
            return;
        }
        board[i][j]='T';
        fn(board,i+1,j);
        fn(board,i,j+1);
        fn(board,i-1,j);
        fn(board,i,j-1);
    }
    
}