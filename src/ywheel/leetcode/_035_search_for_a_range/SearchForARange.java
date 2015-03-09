package ywheel.leetcode._035_search_for_a_range;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author ywheel
 * 
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if (A == null || A.length == 0) {
            return result;
        }
        int l = 0;
        int r = A.length - 1;
        boolean hasTarget = false;
        int mid = (l + r) / 2;
        while (l <= r) {
            mid = (l + r) / 2;
            if (A[mid] == target) {
                hasTarget = true;
                break;
            } else if (A[mid] < target) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        if (!hasTarget) {
            return result;
        }
        // at this point, A[mid] = target, then need to find the range
        // 1. find left range
        l = 0;
        r = mid;
        result[1] = mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (A[mid] == target) {
                r = mid - 1;
            } else {
                // must be less than target
                l = mid + 1;
            }
        }
        result[0] = l;
        // 2. find right range
        l = result[1];
        r = A.length - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (A[mid] == target) {
                l = mid + 1;
            } else {
                // must be great than target
                r = mid - 1;
            }
        }
        result[1] = r;
        
        return result;
    }
    public static void main(String[] args) {
        SearchForARange solution = new SearchForARange();
        int[] result = solution.searchRange(new int[]{5,7,7,8,8,10}, 8);
        if (result != null & result.length == 2) {
            System.out.println(String.format("[%d,%d]", result[0], result[1]));
        }
    }

}
