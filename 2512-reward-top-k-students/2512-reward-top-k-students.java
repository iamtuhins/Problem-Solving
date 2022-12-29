class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String>pSet=new HashSet<>(Arrays.asList(positive_feedback));
        Set<String>nSet=new HashSet<>(Arrays.asList(negative_feedback));
        int temp[][]=new int[report.length][2];
        for(int i=0;i<report.length;i++){
            String arr[]=report[i].split(" ");
            int score=0;
            for(String n: arr){
                if(pSet.contains(n)){
                    score+=3;
                }else if(nSet.contains(n)){
                    score--;
                }
            }
            //y
            temp[i][0]=student_id[i];
            temp[i][1]=score;
        }
        Arrays.sort(temp,(a,b)->a[1]==b[1]?Integer.compare(a[0],b[0]):Integer.compare(b[1],a[1]));
        List<Integer>sol=new ArrayList<>();
        for(int i=0;i<k;i++){
            sol.add(temp[i][0]);
        }
        return sol;
        
    }
}