//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        Collections.sort(A);
        ArrayList<ArrayList<Integer>>sol=new ArrayList<>();
        ArrayList<Integer>tmp=new ArrayList<>();
        fn(sol,A,tmp,0,B,A.size(),0);
        Collections.sort(sol,(n,m)-> Integer.compare(n.get(0),m.get(0)));
        return sol;
        
    }
    static void fn(ArrayList<ArrayList<Integer>>ls,ArrayList<Integer>A,List<Integer>tmp,int sm,int B,int idn,int j){
        if(sm>=B || j>=A.size()){
            if(sm==B){
                ls.add(new ArrayList<Integer>(tmp));
            }
            return;
        }
        for(int i=j;i<idn;i++){
            int temp=A.get(i);
            if(temp>B){
                return;
            }
            if(i>0 && A.get(i)==A.get(i-1)){
               continue;
            }
            tmp.add(temp);
            fn(ls,A,tmp,sm+temp,B,idn,i);
            tmp.remove(tmp.size()-1);
        }
        
    }
}