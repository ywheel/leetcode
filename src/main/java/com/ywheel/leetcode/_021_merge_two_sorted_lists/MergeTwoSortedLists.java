package com.ywheel.leetcode._021_merge_two_sorted_lists;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author ywheel
 * 
 */
public class MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            // merge l2 to l1
            ListNode head = null;
            ListNode prev = null;
            while (l2 != null) {
                if (l1 == null) {
                    prev.next = l2;
                    break;
                }
                if (l1.val > l2.val) {
                    if (prev == null) {
                        prev = l2;
                    } else {
                        prev.next = l2;
                    }
                    ListNode node = l2.next;
                    l2.next = l1;
                    prev = l2;
                    l2 = node;
                } else {
                    prev = l1;
                    l1 = l1.next;
                }
                head = head == null ? prev : head;
                
            }
            return head;
        }
    }
    
    public ListNode construct(int[] A) {
        if (A == null || A.length == 0) return null;
        ListNode head = null;
        ListNode next = null;
        for (int i : A) {
            ListNode node = new ListNode(i);
            if (head == null) {
                head = node;
                next = node;
            } else {
                next.next = node;
                next = node;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode l1 = solution.construct(new int[]{1});
        ListNode l2 = solution.construct(new int[]{1});
        ListNode result = solution.mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
    }
}
