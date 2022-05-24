class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        List<Integer>ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp=capacity[i]-rocks[i];
            ls.add(temp);
        }
        int m=ls.size();
        int sol=0;
        int temp=0;
        Collections.sort(ls);
        for(int i=0;i<m;i++){
            temp=temp+ls.get(i);
            if(temp>additionalRocks){
                break;
            }
            sol++;
        }
        return sol;
    }
}