class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String>sol=new ArrayList<>();
        int sz=Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++){
            String temp=list1[i];
            for(int j=0;j<list2.length;j++){
                if(temp.equals(list2[j]) && sz>=(i+j)){
                    if(sz>(i+j) && sol.size()>=1){
                        sol.remove(sol.size()-1);
                    }
                    sol.add(list1[i]);
                    sz=(i+j);
                }
            }
        }
        String[] solutions=new String[sol.size()];
        for(int i=0;i<solutions.length;i++){
            solutions[i]=sol.get(i);
        }
        return solutions;
    }
}