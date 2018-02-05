package com.ywheel.leetcode._033_search_in_rotated_sorted_array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author ywheel
 * 
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < A[r]) {
                // right side is sorted
                if (target >= A[mid] && target <= A[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                // left side is sorted
                if (target >= A[l] && target <= A[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        System.out.println(solution.search(new int[]{3,5,1}, 3));
        System.out.println(solution.search(new int[]{1,3}, 3));
        System.out.println(solution.search(new int[]{4,5,6,7,8,1,2,3}, 8));
        System.out.println(solution.search(new int[]{5,1,3}, 5));
        System.out.println(solution.search(new int[]{3,1}, 1));
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
