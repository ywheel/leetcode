package ywheel.leetcode._023_merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author ywheel
 * 
 */
public class MergeKSortedLists {
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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                return Integer.compare(l1.val, l2.val);
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        ListNode helper = new ListNode(0);
        ListNode next = helper;
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll(); // must not be null
            next.next = min;
            min = min.next;
            if (min != null) {
                minHeap.add(min);
            }
            next = next.next;
        }
        return helper.next;
    }

    public ListNode construct(int[] A) {
        if (A == null || A.length == 0)
            return null;
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
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode l1 = solution.construct(new int[] { 1,2 });
        ListNode l2 = solution.construct(new int[] { 1,7 });
        ListNode l3 = solution.construct(new int[]{3,5,6});
        List<ListNode> lists = new ArrayList<ListNode>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        ListNode result = solution.mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
    }
}
