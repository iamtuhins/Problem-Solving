//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n;
            n=Integer.parseInt(in.readLine());
            Node head,tail;
            String s[]=in.readLine().trim().split(" ");
            int num=Integer.parseInt(s[0]);
            head=new Node(num);
            tail=head;
            for(int i=1;i<n;i++){
                num=Integer.parseInt(s[i]);
                tail.next=new Node(num);
                tail=tail.next;
            }
            Solution ob=new Solution();
            Node temp=ob.primeList(head);
            while(temp!=null){
                out.print(temp.val+" ");
                temp=temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution
{
    int primes[]=new int[(int)1e5+1];
    Node primeList(Node head){
        //code here
        int n=0;
        buildingPrime();
        Node temp=new Node(0);
        temp.next=head;
        primes[0]=1;
        primes[1]=1;
        while(head!=null){
            head.val=nearPrimes(head.val);
            head=head.next;
        }
        return temp.next; 
    }
    int nearPrimes(int num){
        if(primes[num]==0){
            return num;
        }
        int n1=num-1;
        while(n1>=2 && primes[n1]!=0){
            n1--;
        }
        int n2=num+1;
        while(primes.length>n2 && primes[n2]!=0){
            n2++;
        }
        if(n1<2){
            return n2;
        }
        if(n2>=primes.length){
            return n1;
        }
        int diff=num-n1;
        int diff2=n2-num;
        if(diff>diff2){
            return n2;
        }
        return n1;
    }
    void buildingPrime(){
        for(int i=2;i*i<primes.length;i++){
            if(primes[i]==0){
                for(int j=i*i;j<primes.length;j=j+i){
                    primes[j]=1;
                }
            }
        }
    }
    
}