package onetofifty.addtwonumbers;

import java.util.ArrayList;

/**
 * @author Yunguoran
 * @see <a href="https://leetcode.cn/problems/add-two-numbers/">add-two-numbers</a>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int val) { this.val = val; }
 * }
 */
public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点 head。
        ListNode pre = new ListNode(0);
        // 定义一个游标指针用于移动。
        ListNode cur = pre;
        // 进位标志。
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果最后两个数相加的时候有进位，就将进位数赋予链表的新节点。
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = generateListNodeByArray(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = generateListNodeByArray(new int[]{9, 9, 9, 9});
        printListNode(addTwoNumbers(l1, l2));
    }

    private static ListNode generateListNodeByArray(int[] ints) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (int anInt : ints) {
            cur.next = new ListNode(anInt);
            cur = cur.next;
        }
        return pre.next;
    }

    private static void printListNode(ListNode listNode) {
        ArrayList<Integer> results = new ArrayList<>();
        while (listNode != null) {
            // 利用栈的思想，每次将当前节点放在链表的最前面。
            results.add(0, listNode.val);
            listNode = listNode.next;
        }
        System.out.println(results);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

