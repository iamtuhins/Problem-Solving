class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String>temp=new ArrayList<>();
        int n=list1.length;
        int m=list2.length;
        int size=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            String t1=list1[i];
            for(int j=0;j<m;j++){
                String t2=list2[j];
                if(t1.equals(t2) && size>(i+j)){
                    if(temp.size()>=1){
                        temp.remove(temp.size()-1);
                    }
                    temp.add(list1[i]);
                    size=i+j;
                }else if(t1.equals(t2) && size==(i+j)){
                    temp.add(list1[i]);
                }
            }
        }
        int j=temp.size();
        String []sol=new String[j];
        for(int i=0;i<j;i++){
            sol[i]=temp.get(i);
        }
        return sol;
        
    }
}