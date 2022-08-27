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
        Queue<String>q=new LinkedList<>();
        q.add(beginWord);
        mp.put(beginWord,true);
        int sol=0;
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                String temp=q.remove();
                if(temp.equals(endWord)){
                    return sol+1;
                }
                fn(temp,q,mp);
            }
            sol++;
        }
        return 0;
        
    }
    void fn(String word,Queue<String>q,Map<String,Boolean>mp){
        int arr[]=new int[26];
        int m=word.length();
        for(int i=0;i<m;i++){
            char nums[]=word.toCharArray();
            for(int j=0;j<arr.length;j++){
                char temp=(char)('a'+j);
                nums[i]=temp;
                String s1=String.valueOf(nums);
                if(mp.containsKey(s1) && mp.get(s1)==false){
                    q.add(s1);
                    mp.put(s1,true);
                }
            }
        }
    }
}