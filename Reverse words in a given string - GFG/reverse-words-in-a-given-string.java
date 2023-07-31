//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        int n=S.length();
        StringBuilder sb=new StringBuilder();
        String sol="";
        for(int i=n-1;i>=0;i--){
            if(S.charAt(i)=='.'){
                sb.reverse();
                sol+=sb.toString();
                sol+='.';
                sb=new StringBuilder();
            }else if(i==0){
                sb.append(S.charAt(i));
                sb.reverse();
                sol+=sb.toString();
            }else{
                sb.append(S.charAt(i));
            }
        }
        return sol;
    }
}