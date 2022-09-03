class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        if(n!=t.length())
            return false;
        Map<Character,Character>map=new HashMap<>();
        for(int i=0;i<n;i++){
            char val1=s.charAt(i);
            char val2=t.charAt(i);
            if(!map.containsKey(val1) && !map.containsValue(val2)){
                map.put(val1,val2);
            }else{
                if(map.containsKey(val1)){
                    if(map.get(val1)!=val2)
                        return false;
                }else{
                    return false;
                }
            }
        }
        return true;
       
    }
}