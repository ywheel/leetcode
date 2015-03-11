package ywheel.leetcode._147_insertion_sort_list;
/**
 * Sort a linked list using insertion sort.
 * 
 * @author ywheel
 *
 */
public class InsertionSortList {
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
         public String toString() {
             return String.valueOf(val);
         }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        // start from second node
        ListNode node = head.next;
        ListNode nodePrev = head;
        while (node != null) {
            // start from head node
            ListNode prev = head;
            ListNode curr = head;
            while (curr != node) {
                if (node.val < curr.val) {
                    // insert node before curr
                    nodePrev.next = node.next;
                    node.next = curr;
                    if (curr == head) {
                        head = node;
                    } else {
                        prev.next = node;
                    }
                    node = nodePrev.next;
                    break;
                } else {
                    // continue
                    prev = curr == head ? head : prev.next;
                    curr = curr.next;
                }
            }
            if (curr == node) {
                node = node.next;
                nodePrev = nodePrev.next;
            }
        }
        return head;
    }
    
    public ListNode construct(int[] list) {
        if (list == null || list.length == 0) {
            return null;
        }
        ListNode head = new ListNode(list[0]);
        ListNode curr = head;
        for (int i=1; i<list.length; i++) {
            ListNode next = new ListNode(list[i]);
            curr.next = next;
            curr = curr.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        InsertionSortList solution = new InsertionSortList();
        ListNode head = solution.construct(new int[]{4,2,1,3});
        ListNode result = solution.insertionSortList(head);
        while (result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }
}
