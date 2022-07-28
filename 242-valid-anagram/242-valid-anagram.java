class Solution {
    public boolean isAnagram(String s, String t) {
        int arr[]=new int[26];
        return fn(s,t,arr);
        
        
    }
    boolean fn(String s, String t,int arr[]){
        int n=s.length();
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
        }
        int m=t.length();
        for(int i=0;i<m;i++){
            arr[t.charAt(i)-'a']--;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0 || arr[i]>0){
                return false;
            }
        }
        return true;
    }
}