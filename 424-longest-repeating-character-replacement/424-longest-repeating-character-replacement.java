class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int arr[]=new int[26];
        int maxCount=0;
        int sol=0;
        int left=0;
        for(int right=0;right<n;right++){
            arr[s.charAt(right)-'A']++;
            maxCount=Math.max(maxCount,arr[s.charAt(right)-'A']);
            if((right-left+1-maxCount)>k){
                arr[s.charAt(left)-'A']--;
                left++;
            }
            sol=Math.max((right-left+1),sol);
        }
        return sol;
        
        
    }
}