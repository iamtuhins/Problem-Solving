class Solution {
    public String decodeMessage(String key, String message) {
        int n=key.length();
        Map<Character,Character>map=new HashMap<>();
        int m=message.length();
        char val='a';
        for(int i=0;i<n;i++){
            char temp=key.charAt(i);
            if(temp!=' ' && !map.containsKey(temp)){
                map.put(temp,val);
                val++;
            }
        }
        String sol="";
        for(int i=0;i<m;i++){
            char temp=message.charAt(i);
            if(temp==' '){
                sol=sol+temp;
            }else{
                sol=sol+map.get(temp);
            }
        }
        return sol;
        
    }
}