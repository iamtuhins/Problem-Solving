class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        if(n==0){
            int tempVal[]=new int[numCourses];
            for(int i=0;i<numCourses;i++){
                tempVal[i]=i;
            }
            return tempVal;
        }
        List<List<Integer>>madj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            madj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            int v=prerequisites[i][0];
            int m=prerequisites[i][1];
            madj.get(v).add(m);
        }
        int vist[]=new int[numCourses];
        int dfsVist[]=new int[numCourses];
        List<Integer>sol=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(vist[i]==0){
                boolean tm=fn(i,madj,sol,vist,dfsVist);
                if(tm==false){
                    return new int[0];
                }
            }
        }
        int nums[]=new int[numCourses];
        int sz=sol.size();
        if(sz!=numCourses){
            return nums;
        }
        for(int i=0;i<numCourses;i++){
            nums[i]=sol.get(i);
        }
        
        return nums;
        
    }
    boolean fn(int id,List<List<Integer>>madj,List<Integer>sol,int []vist,int []dfsVist){
        dfsVist[id]=1;
        vist[id]=1;
        for(int temp: madj.get(id)){
            if(vist[temp]==0){
                boolean tm=fn(temp,madj,sol,vist,dfsVist);
                if(tm==false){
                    return false;
                }
            }else if(dfsVist[temp]==1 && vist[temp]==1){
                return false;
            }
        }
        dfsVist[id]=0;
        sol.add(id);
        return true;
        
    }
}