class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n=wordList.size();
        if(!wordList.contains(endWord)){
            return 0;
        }
        Map<String,Boolean>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(wordList.get(i),false);
        }
        int sol=0;
        mp.put(beginWord,true);
        Queue<String>q=new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                String st=q.remove();
                if(st.equals(endWord)){
                    return sol+1;
                }
                fn(st,mp,q);
            }
            sol++;
        }
        return 0;
        
    }
    void fn(String val,Map<String,Boolean>mp,Queue<String>q){
        int n=val.length();
        for(int i=0;i<n;i++){
            char arr[]=val.toCharArray();
            for(int j=0;j<26;j++){
                char temp=(char) ('a'+j);
                arr[i]=temp;
                String st=String.valueOf(arr);
                if(mp.containsKey(st) && mp.get(st)==false){
                    q.add(st);
                    mp.put(st,true);
                }
            }
        }
    }
}