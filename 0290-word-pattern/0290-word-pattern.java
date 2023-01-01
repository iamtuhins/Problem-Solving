class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[]=s.split(" ");
        Map<Character,String>mp=new HashMap<>();
        Map<String,Character>np=new HashMap<>();
        if(arr.length!=pattern.length()){
           return false;
        }
        for(int i=0;i<arr.length;i++){
            char nm=pattern.charAt(i);
            if(mp.containsKey(nm)){
                String temp=mp.get(pattern.charAt(i));
                if(!temp.equals(arr[i])){
                    return false;
                }
            }else{
                if(np.containsKey(arr[i])){
                    return false;
                }
                mp.put(nm,arr[i]);
                np.put(arr[i],nm);
            }
        }
        return true;
        
    }
}