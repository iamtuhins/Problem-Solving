class Solution {
    public String removeDigit(String number, char digit) {
        int n=number.length();
        List<String>ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(number.charAt(i)==digit){
                String withOutDigits=number.substring(0,i)+number.substring(i+1);
                ls.add(withOutDigits);
            }
        }
        Collections.sort(ls);
        int m=ls.size();
        return ls.get(m-1);
        
    }
}