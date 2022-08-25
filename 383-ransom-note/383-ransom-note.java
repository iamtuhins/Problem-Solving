class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        boolean sol=fn(magazine,ransomNote);
        return sol;
            
        
    }
    boolean fn(String s1,String s2){
        int note[]=new int[26];
        int n=s1.length();
        int m=s2.length();
        for(int i=0;i<n;i++){
            note[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<m;i++){
            note[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<note.length;i++){
            if(note[i]<0){
                return false;
            }
        }
        return true;
    }
}