class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();
        int counts=0;
        for(int i=0;i<m;i++){
            String tm="";
            String temp="";
            for(int j=0;j<n;j++){
                temp+=strs[j].charAt(i);
                tm+=strs[j].charAt(i);
            }
            char nums[]=temp.toCharArray();
            Arrays.sort(nums);
            temp=new String(nums);
            if(!tm.equals(temp)){
                counts++;
            }
        }
        return counts;
        
    }
}