class Solution {
    public int countCharacters(String[] words, String chars) {
        int n=words.length;
        int sol=0;
        for(int i=0;i<n;i++){
            if(fn(words[i],chars)){
                sol=sol+words[i].length();
            }
        }
        return sol;
        
    }
    boolean fn(String s1,String s2){
        int arr[]=new int[26];
        int m=s2.length();
        int n=s1.length();
        for(int i=0;i<m;i++){
            arr[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            arr[s1.charAt(i)-'a']--;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                return false;
            }
        }
        return true;
    }
}