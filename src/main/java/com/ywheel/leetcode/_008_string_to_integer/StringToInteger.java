package com.ywheel.leetcode._008_string_to_integer;

/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 *
 * Created by ywheel on 2018/2/6.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        long result = 0L;
        boolean positive = true;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-') {
                if (i != 0) {
                    return 0;
                }
                positive = false;
            } else if (chars[i] == '+') {
                if (i != 0) {
                    return 0;
                }
                positive = true;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                result = result * 10 + (chars[i] - '0');
                if (result > Integer.MAX_VALUE) {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        result = positive ? result : -result;
        return (int)result;
    }
}
