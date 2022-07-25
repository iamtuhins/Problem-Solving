class Solution {
    public char repeatedCharacter(String s) {
        int arr[]=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            char temp=s.charAt(i);
            arr[temp-'a']++;
            if(arr[temp-'a']==2){
                return s.charAt(i);
            }
        }
        return s.charAt(0);
        
    }
}