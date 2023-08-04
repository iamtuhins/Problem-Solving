//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        List<Pair>lst=new ArrayList<>();
        for(int i=0;i<n;i++){
            double unitValue=(1.0*arr[i].value)/arr[i].weight;
            lst.add(new Pair(unitValue,arr[i]));
        }
        Collections.sort(lst,new CustomCom());
        double totalValue=0;
        for(int i=0;i<n;i++){
            Pair temp=lst.get(i);
            if(temp.item.weight>W){
                totalValue+=(temp.val)*W;
                W=0;
            }else{
                totalValue+=temp.item.value;
                W-=temp.item.weight;
            }
        }
        return totalValue;
        
        
        
        
    }
}
class Pair{
    double val;
    Item item;
    Pair(double val,Item item){
        this.val=val;
        this.item=item;
    }
}
class CustomCom implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.val>p2.val){
            return -1;
        }else{
            return 1;
        }
    }
}


