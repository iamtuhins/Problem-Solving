class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int dirt[][]={{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
                fn(board,dirt,0,i);
            }
            if(board[n-1][i]=='O'){
                fn(board,dirt,n-1,i);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                fn(board,dirt,i,0);
            }
            if(board[i][m-1]=='O'){
                fn(board,dirt,i,m-1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='m'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        
    }
    void fn(char board[][],int dirt[][],int idn,int idm){
        board[idn][idm]='m';
        for(int i=0;i<4;i++){
            int putRow=idn+dirt[i][0];
            int putColm=idm+dirt[i][1];
            if(putRow>=0 && putColm>=0 && putRow<board.length && putColm<board[0].length){
                if(board[putRow][putColm]=='O'){
                    fn(board,dirt,putRow,putColm);
                }
            }
        }
    }
}