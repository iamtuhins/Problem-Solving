class Solution {
    public int minDeletionSize(String[] strs) {
        int sol=0;
        int n=strs.length;
        int m=strs[0].length();
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                if(strs[j-1].charAt(i)>strs[j].charAt(i)){
                    sol++;
                    break;
                }
            }
        }
        return sol;
        
    }
}