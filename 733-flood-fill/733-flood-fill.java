class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int dirt[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int vt[][]=new int[image.length][image[0].length];
        fn(image,sr,sc,color,vt,dirt);
        return image;
        
    }
   void fn(int [][]arr,int idN,int idM,int color,int vist[][],int dirt[][]){
       int temp=arr[idN][idM];
       arr[idN][idM]=color;
       vist[idN][idM]=1;
       for(int i=0;i<dirt.length;i++){
           int putN=idN+dirt[i][0];
           int putM=idM+dirt[i][1];
           if(putN>=0 && putM>=0 && putN<arr.length && putM<arr[0].length && vist[putN][putM]==0 && arr[putN][putM]==temp){
               fn(arr,putN,putM,color,vist,dirt);
           }
           
       }
   }
}