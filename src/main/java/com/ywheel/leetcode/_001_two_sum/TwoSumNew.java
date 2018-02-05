package com.ywheel.leetcode._001_two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * @author ywheel
 * 
 */
public class TwoSumNew {
	public int[] twoSum(final int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int another = target - numbers[i];
			if (map.containsKey(another)) {
				return new int[]{map.get(another), i};
			}
			map.put(numbers[i], i);
		}
		return null;
	}
}
