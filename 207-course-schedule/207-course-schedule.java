class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        Map<Integer,List<Integer>>mp=new HashMap<>();
        int arr[]=new int[numCourses];
        for(int i=0;i<n;i++){
            int prerequ=prerequisites[i][1];
            int depends=prerequisites[i][0];
            mp.putIfAbsent(prerequ,new ArrayList<Integer>());
            mp.get(prerequ).add(depends);
            arr[depends]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(arr[i]==0){
                q.add(i);
            }
        }
        int sol=0;
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                int val=q.remove();
                sol++;
                List<Integer>temp=mp.get(val);
                if(temp==null){
                    break;
                }
                for(int nm: temp){
                    arr[nm]--;
                    if(arr[nm]==0){
                        q.add(nm);
                    }
                }
            }
        }
        if(sol>=numCourses){
            return true;
        }
        return false;
        
        
    }
}