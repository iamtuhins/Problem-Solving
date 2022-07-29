class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int n=words.length;
        List<String>sol=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(matchWord(pattern,words[i])){
                sol.add(words[i]);
            }
        }
        return sol;
        
    }
    boolean matchWord(String st1, String st2){
        int n=st1.length();
        int m=st2.length();
        if(m!=n){
            return false;
        }
        Map<Character,Integer>mp1=new HashMap<>();
        Map<Character,Integer>mp2=new HashMap<>();
        for(int i=0;i<n;i++){
            char w1=st1.charAt(i);
            char w2=st2.charAt(i);
            boolean nm1=mp1.containsKey(w1);
            boolean nm2=mp2.containsKey(w2);
            if(nm1!=nm2){
                return false;
            }
            if(nm1){
                int num1=mp1.get(w1);
                int num2=mp2.get(w2);
                if(num1!=num2){
                    return false;
                }
                mp1.put(w1,i);
                mp2.put(w2,i);
            }else{
                mp1.put(w1,i);
                mp2.put(w2,i);
            }
        }
        return true;
    }
}