class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (n,m)-> Integer.compare(m[k],n[k]));
        return score;
    } 
}