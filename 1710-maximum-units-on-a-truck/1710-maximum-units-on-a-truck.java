class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n=boxTypes.length;
        Arrays.sort(boxTypes,Comparator.comparingInt(o->-o[1]));
        int sol=0;
        int num=0;
        int i=0;
        while(i<n && truckSize>0){
            int temp=Math.min(boxTypes[i][0],truckSize);
            sol=sol+(temp*boxTypes[i][1]);
            i++;
            truckSize=truckSize-temp;
        }
        return sol;
    }
}