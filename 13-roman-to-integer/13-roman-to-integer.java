class Solution {
    public int romanToInt(String s) {
        int n=s.length();
        Map<Character,Integer>mp=new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int sol=0;
        for(int i=0;i<n;i++){
            int temp=mp.get(s.charAt(i));
            if(i==n-1 ||temp>=mp.get(s.charAt(i+1))){
                sol=sol+temp;
            }else{
                int tm=mp.get(s.charAt(i+1));
                int diff=tm-temp;
                sol=sol+diff;
                i++;
            }
        }
        return sol;
        
    }
}