class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int pp=ppp(garbage,travel,garbage.length);
        int gb=gbg(garbage,travel,garbage.length);
        int mm=mtl(garbage,travel,garbage.length);
        int sol=pp+gb+mm;
        return sol;
        
        
        
    }
    int ppp(String garbage[],int []travel,int n){
        int time=0;
        int tt=0;
        for(int i=0;i<n;i++){
            if(i>0){
                tt=tt+travel[i-1];
            }
            int temp=0;
            char arr[]=garbage[i].toCharArray();
            for(int j=0;j<arr.length;j++){
                if(arr[j]=='P'){
                    temp=temp+1;
                }
            }
            if(temp>0){
                time=time+tt+temp;
                tt=0;
            }
        }
        return time;
    }
    int gbg(String garbage[],int travel[],int n){
        int time=0;
        int tt=0;
        for(int i=0;i<n;i++){
            if(i>0){
                tt=tt+travel[i-1];
            }
            char arr[]=garbage[i].toCharArray();
            int temp=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]=='G'){
                    temp=temp+1;
                }
            }
            if(temp>0){
                time=time+tt+temp;
                tt=0;
            }
        }
        return time;
    }
    int mtl(String garbage[],int []travel,int n){
        int time=0;
        int tt=0;
        for(int i=0;i<n;i++){
            char arr[]=garbage[i].toCharArray();
            if(i>0){
                tt=tt+travel[i-1];
            }
            int temp=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]=='M'){
                    temp=temp+1;
                }
            }
            if(temp>0){
                time=time+tt+temp;
                tt=0;
            }
        }
        return time;
    }
}