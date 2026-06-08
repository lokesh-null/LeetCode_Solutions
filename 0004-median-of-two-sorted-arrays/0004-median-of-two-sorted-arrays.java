import java.util.Arrays;

class Solution{
    public double findMedianSortedArrays(int[] arr1, int[] arr2){
        int a = arr1.length;
        int b = arr2.length;

        int[] merged_arr = new int[a + b];
        int k = 0;
        for (int i = 0; i < a; i++) {
            merged_arr[k++] = arr1[i];
        }
        for (int i = 0; i < b; i++) {
            merged_arr[k++] = arr2[i];
        }
        Arrays.sort(merged_arr);
        int total = merged_arr.length;
        if (total % 2 == 1) {
            return (double) merged_arr[total / 2];
        }
        else {
            int mid1 = merged_arr[total/2-1];
            int mid2 = merged_arr[total/2];
            return ((double) mid1 + (double) mid2) /2.0;
        }
    }

}