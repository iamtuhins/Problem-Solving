//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        CustomComparators cm=new CustomComparators();
        PriorityQueue<Node>pq=new PriorityQueue<>(cm);
        for(int i=0;i<f.length;i++){
            pq.add(new Node(f[i]));
        }
        while(pq.size()!=1){
            Node num1=pq.poll();
            Node num2=pq.poll();
            Node nodeNew=new Node(num1.data+num2.data);
            nodeNew.left=num1;
            nodeNew.right=num2;
            pq.add(nodeNew);
        }
        Node val=pq.poll();
        ArrayList<String>lst=new ArrayList<>();
        String temp="";
        traverse(val,temp,lst);
        return lst;
    }
    void traverse(Node nd,String temp,ArrayList<String>lst){
        if(nd.left==null && nd.right==null){
            lst.add(temp);
            return;
        }
        traverse(nd.left,temp+'0',lst);
        traverse(nd.right,temp+'1',lst);
    }
}
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
class CustomComparators implements Comparator<Node>{
    public int compare(Node n1,Node n2){
        if(n1.data==n2.data){
            return 1;
        }else{
            return n1.data-n2.data;
        }
    }
}