class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n=words1.length;
        int m=words2.length;
        int count[]=new int[26];
        for(int i=0;i<m;i++){
            int temp[]=fn(words2[i]);
            for(int j=0;j<count.length;j++){
                count[j]=Math.max(temp[j],count[j]);
            }
        }
        List<String>sol=new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp[]=fn(words1[i]);
            for(int j=0;j<count.length;j++){
                if(count[j]>temp[j]){
                    break;
                }
                if(j==25){
                    sol.add(words1[i]);
                }
            }
        }
        return sol;
    }
    int[] fn(String st){
        int nums[]=new int[26];
        int n=st.length();
        for(int i=0;i<n;i++){
            nums[st.charAt(i)-'a']++;
        }
        return nums;
    }
}