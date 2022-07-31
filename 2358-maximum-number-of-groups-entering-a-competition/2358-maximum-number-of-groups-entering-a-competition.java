class Solution {
    public int maximumGroups(int[] grades) {
        int n=grades.length;
        int sol=1;
        int temp=0;
        for(int i=1;i<=grades.length;i++){
            temp=temp+i;
            if((n-temp)>i){
                sol++;
            }else{
                break;
            }
        }
        
        return sol;
    }
}