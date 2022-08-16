class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        Map<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            char temp=s.charAt(i);
            mp.put(temp,mp.getOrDefault(temp,0)+1);
        }
        for(int i=0;i<n;i++){
            char temp=s.charAt(i);
            int num=mp.get(temp);
            if(num==1){
                return i;
            }
        }
        return -1;
        
    }
}