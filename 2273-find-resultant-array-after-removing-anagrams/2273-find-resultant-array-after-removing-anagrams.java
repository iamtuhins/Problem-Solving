class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n=words.length;
        List<String>sol=new ArrayList<>();
        sol.add(words[0]);
        int id=0;
        for(int i=1;i<n;i++){
            if(!isAnagram(words[i],words[i-1])){
                sol.add(words[i]);
                id++;
            }
        }
        return sol;
        
    }
    boolean isAnagram(String st1,String st2){
        if(st1.length()!=st2.length()){
            return false;
        }
        int n=st1.length();
        int counts[]=new int[26];
        for(int i=0;i<n;i++){
            counts[st1.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            counts[st2.charAt(i)-'a']--;
        }
        for(int i=0;i<counts.length;i++){
            if(counts[i]!=0){
                return false;
            }
        }
        return true;
    }
}