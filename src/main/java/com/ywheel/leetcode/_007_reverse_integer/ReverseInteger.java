package com.ywheel.leetcode._007_reverse_integer;

import java.util.*;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output:  321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 * Created by ywheel on 2018/2/5.
 */
public class ReverseInteger {
    public int reverse(int x) {
       int y = x < 0 ? -x : x;
       long z = 0;
       while (y > 0) {
           z = (z * 10) + (y % 10);
           y = y / 10;
       }
       if (z > Integer.MAX_VALUE || z < Integer.MIN_VALUE) {
           return 0;
       }
       return x < 0 ? (int)-z : (int)z;
    }

}
