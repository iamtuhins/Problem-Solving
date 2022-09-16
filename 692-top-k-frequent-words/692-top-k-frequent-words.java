class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer>mp=new HashMap<>();
        for(int i=0;i<words.length;i++){
            mp.put(words[i],mp.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<String,Integer>en: mp.entrySet()){
            pq.add(new Pair(en.getKey(),en.getValue()));
        }
        List<String>sol=new ArrayList<>();
        for(int i=0;i<k;i++){
            Pair p=pq.poll();
            sol.add(p.st);
        }
        return sol;
        
    }
}
class Pair implements Comparable<Pair>{
    int num;
    String st;
    Pair(String s1,int n){
        this.num=n;
        this.st=s1;
    }
    public int compareTo(Pair p){
        if(this.num==p.num)return (p.st).compareTo(this.st);
        return this.num-p.num;
    }
    
}