class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=p.length();
        int m=s.length();
        List<Integer>sol=new ArrayList<>();
        if(n>m){
            return sol;
        }
        int pArr[]=new int[26];
        int sArr[]=new int[26];
        for(int i=0;i<n;i++){
            pArr[p.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            sArr[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(pArr,sArr)){
            sol.add(0);
        }
        int left=0;
        int right=n;
        while(right<m){
            sArr[s.charAt(left)-'a']--;
            left++;
            sArr[s.charAt(right)-'a']++;
            right++;
            if(Arrays.equals(pArr,sArr)){
                sol.add(left);
            }
        }
        return sol;
        
    }
}