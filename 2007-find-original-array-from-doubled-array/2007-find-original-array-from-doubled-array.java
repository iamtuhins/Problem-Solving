class Solution {
    public int[] findOriginalArray(int[] changed) {
        int[] temp = new int[changed.length/2];
    Queue<Integer> y = new LinkedList<>();
    Arrays.sort(changed);
    int i = 0;
    for(int num : changed){
        if(!y.isEmpty() && y.peek()==num)
            temp[i++] = y.poll()/2;
        else y.add(num*2);
    }
    return y.size()>0 ? new int[]{}:temp;
    }
}