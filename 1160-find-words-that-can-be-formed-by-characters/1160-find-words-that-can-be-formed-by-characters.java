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
    boolean fn(String t1,String t2){
            int temp[]=new int[26];
            int n=t1.length();
            int m=t2.length();
            for(int i=0;i<n;i++){
                temp[t1.charAt(i)-'a']++;
            }
            for(int i=0;i<m;i++){
                temp[t2.charAt(i)-'a']--;
            }
            for(int i=0;i<temp.length;i++){
                if(temp[i]<0){
                    return false;
                }
            }
            return true;
        }
}