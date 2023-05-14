class Solution {
    public int[] circularGameLosers(int n, int k) {
        int arr[]=new int[n];
        int id=0;
        int nums=0;
        while(arr[id%n]<1){
            nums++;
            arr[id%n]++;
            id+=k*nums;
        }
        List<Integer>ls=new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(arr[i]==0){
                ls.add(i+1);
            }
        }
        int sol[]=new int[ls.size()];
        for(int i=0;i<sol.length;i++){
            sol[i]=ls.get(i);
        }
        Arrays.sort(sol);
        return sol;
        
    }
}