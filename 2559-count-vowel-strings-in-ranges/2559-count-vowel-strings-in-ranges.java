class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int vl[][]=new int[n][2];
        int counts=0;
      for(int i=0;i<n;i++){
          if(fn(words[i])==true){
              counts++;
              vl[i][0]=counts;
              vl[i][1]=1;
          }else{
              vl[i][0]=counts;
          }
      }
        int sol[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int q1=queries[i][0];
            int q2=queries[i][1];
            int vm=0;
            if(vl[q1][1]==1){
                vm=(vl[q2][0]-vl[q1][0])+1;
            }else{
                vm=vl[q2][0]-vl[q1][0];
            }
            sol[i]=vm;
        }
        return sol;
        
    }
    boolean fn(String sn){
        int n=sn.length();
        char ch1=sn.charAt(0);
        char ch2=sn.charAt(n-1);
        if(ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o' ||ch1=='u'){
            if(ch2=='a' || ch2=='e' || ch2=='i' || ch2=='o' || ch2=='u'){
                return true;
            }
        }
        return false;
    }
}