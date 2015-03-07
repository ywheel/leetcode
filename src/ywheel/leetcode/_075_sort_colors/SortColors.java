package ywheel.leetcode._075_sort_colors;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * click to show follow up.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author ywheel
 * 
 */
public class SortColors {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) return;
        int zero = 0;
        int two = A.length - 1;
        int i = 0;
        while (i <= two) {
            if (A[i] == 0) {
                swap(A, zero, i);
                zero++;
            }
            if (A[i] == 2) {
                swap(A, i, two);
                two--;
            } else {
                i++;
            }
        }
    }
    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    
    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] A = new int[]{0, 1, 2, 1, 0, 2, 1, 0, 0};
        solution.sortColors(A);
        for (int i=0; i<A.length; i++) {
            System.out.print(A[i] + ", ");
        }
    }
    
}
