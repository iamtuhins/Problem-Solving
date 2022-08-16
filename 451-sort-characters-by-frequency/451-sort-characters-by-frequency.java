class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        Map<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            char temp=s.charAt(i);
            mp.put(temp,mp.getOrDefault(temp,0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(Map.Entry<Character,Integer>en: mp.entrySet()){
            char temp=en.getKey();
            int val=en.getValue();
            pq.add(new Pair(val,temp));
        }
        String sol="";
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int num=p.num;
            char val=p.val;
            for(int i=0;i<num;i++){
                sol=sol+val;
            }
            
        }
        return sol;
    }
}
class Pair implements Comparable<Pair>{
    int num;
    char val;
    Pair(int n,char v){
        this.num=n;
        this.val=v;
    }
    public int compareTo(Pair ob){
        return ob.num-this.num;
    }
    
}