class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int idN=0;
        int idM=0;
        int sol=0;
        HashSet<Character>set=new HashSet<>();
        while(idN<n){
            char temp=s.charAt(idN);
            if(set.contains(temp)){
                while(set.contains(temp)){
                    set.remove(s.charAt(idM));
                    idM++;
                }
            }else{
                set.add(temp);
                idN++;
            }
            sol=Math.max(sol,set.size());
        }
        return sol;
    }
}