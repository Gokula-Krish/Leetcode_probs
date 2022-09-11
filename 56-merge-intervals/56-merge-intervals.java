class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        LinkedList<int[]> list=new LinkedList();
        for(int[] arr:intervals){
            if(list.isEmpty() || list.getLast()[1]<arr[0]){
                list.add(arr);
            }
            else{
                list.getLast()[1]=Math.max(arr[1],list.getLast()[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}