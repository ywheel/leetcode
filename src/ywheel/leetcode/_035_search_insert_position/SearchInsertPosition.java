package ywheel.leetcode._035_search_insert_position;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. 
 * [1,3,5,6], 5 → 2 
 * [1,3,5,6], 2 → 1 
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * @author ywheel
 * 
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        return l;
    }
    
    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();
        int[] A = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(A, 5));
        System.out.println(solution.searchInsert(A, 2));
        System.out.println(solution.searchInsert(A, 7));
        System.out.println(solution.searchInsert(A, 0));
    }
}
