class Solution {
    public String decodeString(String s) {
        int n=s.length();
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<n;i++){
            char val=s.charAt(i);
            if(val!=']'){
                stack.push(val);
            }else{
                StringBuilder sb=new StringBuilder();
                while(Character.isLetter(stack.peek())){
                    sb.insert(0,stack.pop());
                }
                String word=sb.toString();
                stack.pop();
                sb=new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb.insert(0,stack.pop());
                }
                int nums=Integer.valueOf(sb.toString());
                while(nums>0){
                    for(char m: word.toCharArray()){
                        stack.push(m);
                    }
                    nums--;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        String sol=sb.toString();
        return sol;
        
    }
}