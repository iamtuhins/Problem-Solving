class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int sol=0;
        //sorting array for getting the lowest and highest floor
        Arrays.sort(special);
        //Diffrence between bottom and lowset floor
        int buttom_num=special[0]-bottom;
        //Diffrence between top and highest floor
        int top_num=top-special[special.length-1];
        //Maximum  them
        sol=Math.max(buttom_num,top_num);
        int diff=0;
        //Finding the diffrence between floors to get any place exist between floors
        for(int i=1;i<special.length;i++){
            diff=Math.max(diff,(special[i]-special[i-1])-1);
        }
        //solution will the largest of them
        sol=Math.max(sol,diff);
        return sol;
        
    }
}