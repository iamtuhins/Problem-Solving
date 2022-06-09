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
    boolean fn(String t1, String t2){
        int []arr=new int[26];
        int n=t1.length();
        int m=t2.length();
        for(int i=0;i<m;i++){
            arr[t2.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            arr[t1.charAt(i)-'a']--;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                return false;
            }
        }
        return true;
    }
}