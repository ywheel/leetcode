package com.ywheel.leetcode._032_longest_valid_parentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * @author ywheel
 * 
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        if (s == null || s.isEmpty()) return max;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i<len; i++) {
            char c = s.charAt(i);
            if (c == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                if (stack.isEmpty()) {
                    max  = i+1;
                } else {
                    int valid_len = i - stack.peek();
                    max = max > valid_len ? max : valid_len;
                }
            } else {
                stack.push(i);
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        System.out.println(solution.longestValidParentheses("()(()"));
    }
}
