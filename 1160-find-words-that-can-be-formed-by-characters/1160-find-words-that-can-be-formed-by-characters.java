class Solution {
    public int countCharacters(String[] words, String chars) {
        int n=words.length;
        int sol=0;
        for(int i=0;i<n;i++){
            if(fn(chars,words[i])){
                sol=sol+words[i].length();
            }
        }
        return sol;
        
    }
    boolean fn(String st1,String st2){
        int temp[]=new int[26];
        int n=st1.length();
        int m=st2.length();
        for(int i=0;i<n;i++){
            temp[st1.charAt(i)-'a']++;
        }
        for(int i=0;i<m;i++){
            temp[st2.charAt(i)-'a']--;
        }
        for(int i=0;i<temp.length;i++){
            if(temp[i]<0){
                return false;
            }
        }
        return true;
    }
}