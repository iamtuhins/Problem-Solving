class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer>temp=new ArrayList<>();
        for(int i=1;i<=9;i++){
            fn(i,temp,1,k,i,n);
        }
        int sol[]=new int[temp.size()];
        int size=temp.size();
        for(int i=0;i<size;i++){
            sol[i]=temp.get(i);
        }
        return sol;
        
    }
    void fn(int num,List<Integer>temp,int n,int k,int prev,int now){
        if(n==now){
            temp.add(num);
            return;
        }
        int next=prev+k;
        if(next<10){
            fn((num*10)+next,temp,n+1,k,next,now);
        }
        next=prev-k;
        if(k!=0 && next>=0){
            fn((num*10)+next,temp,n+1,k,next,now);
        }
            
    }
}