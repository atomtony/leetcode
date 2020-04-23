package c2;


import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode last = null;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (root == null) {
                root = new ListNode(sum);
                last = root;
            } else {
                last.next = new ListNode(sum);
                last = last.next;
            }
        }

        last = root;
        while (last != null) {
            if (last.val >= 10) {
                if (last.next != null) {
                    last.next.val = last.next.val + 1;
                    last.val = last.val % 10;
                } else {
                    ListNode tmp = new ListNode(1);
                    last.val = last.val % 10;
                    last.next = tmp;
                }
            }
            last = last.next;
        }
        return root;
    }

    public static ListNode createListNode(List<Integer> list) {
        ListNode root = null;
        ListNode currentNode = null;
        for (Integer val : list) {
            ListNode node = new ListNode((int) (long) val);
            if (root == null) {
                root = node;
                currentNode = root;
            } else {
                currentNode.next = node;
                currentNode = node;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = createListNode(Arrays.asList(9));
        ListNode l2 = createListNode(Arrays.asList(1, 9, 9, 9, 9, 9, 9, 9, 9, 9));
        ListNode result = new Solution().addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.printf("" + result.val);
            result = result.next;
        }
        System.out.println();
    }
}
