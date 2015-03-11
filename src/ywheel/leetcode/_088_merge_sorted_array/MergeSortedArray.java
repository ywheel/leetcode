package ywheel.leetcode._088_merge_sorted_array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space (size that is greater or equal
 * to m + n) to hold additional elements from B. The number of elements
 * initialized in A and B are m and n respectively.
 * 
 * @author ywheel
 * 
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || A.length <  m+n) {
            return;
        }
        int a = m - 1;
        int b = n - 1;
        for (int i=m+n-1; i>=0; i--) {
            if (a >=0 && b >= 0) {
                if (A[a] > B[b]) {
                    A[i] = A[a--];
                } else {
                    A[i] = B[b--];
                }
            } else if (a < 0) {
                // only left B
                System.arraycopy(B, 0, A, 0, i+1);
            } // else {
                // only left A, do nothing
            //}
        }
    }
    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        int[] A = new int[]{1,4,6, 0, 0};
        solution.merge(A, 3, new int[]{3, 5}, 2);
        for (int i : A) {
            System.out.print(i + ",");
        }
    }
}
