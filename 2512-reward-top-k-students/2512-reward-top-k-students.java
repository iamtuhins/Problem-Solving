class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String>nSet=new HashSet<>(Arrays.asList(positive_feedback));
        Set<String>mSet=new HashSet<>(Arrays.asList(negative_feedback));
        int arrs[][]=new int[report.length][2];
        for(int i=0;i<report.length;i++){
            String temp[]=report[i].split(" ");
            int score=0;
            for(String mn: temp){
                if(nSet.contains(mn)){
                    score+=3;
                }else if(mSet.contains(mn)){
                    score--;
                }
            }
            arrs[i][0]=student_id[i];
            arrs[i][1]=score;
        }
        Arrays.sort(arrs,(a,b)->a[1]==b[1]? Integer.compare(a[0],b[0]): Integer.compare(b[1],a[1]));
        List<Integer>sol=new ArrayList<>();
        for(int i=0;i<k;i++){
            sol.add(arrs[i][0]);
        }
        return sol;
        
    }
}