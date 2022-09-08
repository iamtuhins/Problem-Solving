/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int idn=1;
        int idm=n;
        while(idn<idm){
            int pivot=idn+(idm-idn)/2;
            if(isBadVersion(pivot)){
                idm=pivot;
            }else{
                idn=pivot+1;
            }
        }
        int sol=idm;
        return sol;
        
    }
}