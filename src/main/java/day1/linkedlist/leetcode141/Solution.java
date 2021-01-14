package day1.linkedlist.leetcode141;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> nodes = new HashSet<>();
//        while (head != null) {
//            if (nodes.contains(head)) {
//                return true;
//            } else {
//                nodes.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }


}
