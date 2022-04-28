1. I will firstly store 0-element of each List form the  nums in PriorityQueue.
2. find the min and max value of them.
3. now poll the priorityQueue to get the minmum value and see if current max-currentMin is less than privious max-previousMin than store update start and end value.
4. so we'll now add the next element of the list from where last element was pop and if it is large than the max value update that and store in Queue.