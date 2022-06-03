class Solution {
    public int rearrangeCharacters(String s, String target) {
        //Map to keep track of s char counting
        int arr[]=new int[26];
        int n=s.length();
        //Map to keep track of target counting
        int arr1[]=new int[26];
        int m=target.length();
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<m;i++){
            arr1[target.charAt(i)-'a']++;
        }
        int min=Integer.MAX_VALUE;
        //Getting the total count avalable to make the word(totalNumber/avilable) get
        for(int i=0;i<m;i++){
            char temp=target.charAt(i);
            min=Math.min(min,arr[temp-'a']/arr1[temp-'a']);
        }
        return min;
        
    }
}