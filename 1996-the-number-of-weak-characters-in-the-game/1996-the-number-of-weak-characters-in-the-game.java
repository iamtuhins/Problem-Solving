class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int sol=0;
        int n=properties.length;
        Arrays.sort(properties,(a,b)-> (a[0]==b[0])? Integer.compare(b[1],a[1]): Integer.compare(a[0],b[0]));
        int dNum=properties[n-1][1];
        for(int i=n-2;i>=0;i--){
            if(dNum>properties[i][1]){
                sol++;
            }else if(properties[i][1]>dNum){
                dNum=properties[i][1];
            }
        }
        return sol;
        
    }
}