package com.fankf.lee;

import java.util.LinkedList;
import java.util.List;

/**
 * fankunfeng
 * 2020-10-28 22:11
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class LeeCode2 {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int k1 = 0;
        int k2 = 0;
        int kk = 0;
        int zz = 0;
        while (l1 != null) {
            k1 += (int) Math.pow(10, kk) * l1.val;
            l1 = l1.next;
            kk++;

        }
        while (l2 != null) {
            k2 += (int) Math.pow(10, zz) * l2.val;
            l2 = l2.next;
            zz++;
        }
        int k = k1 + k2;
        kk = kk < zz ? zz : kk;
        kk = k / (int) Math.pow(10, kk) >= 1 ? kk + 1 : kk;

        ListNode l3 = null;
        do {
            kk--;
            k1 = k / (int) Math.pow(10, kk);
            k = k % (int) Math.pow(10, kk);
            l3 = new ListNode(k1, l3);

        } while (kk != 0);
        return l3;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode now = result;
        int index = 0;
        while (l1 != null || l2 != null || index != 0) {
            int m = l1 == null ? 0 : l1.val;
            int n = l2 == null ? 0 : l2.val;
            int v = m + n + index;
            ListNode node = new ListNode(v % 10);
            index = v / 10;
            now.next = node;
            now = node;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return result.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(3, null);
        node1 = new ListNode(4, node1);
        node1 = new ListNode(2, node1);
        ListNode node4 = new ListNode(4, null);
        node4 = new ListNode(6, node4);
        node4 = new ListNode(5, node4);
        LeeCode2 leeCode2 = new LeeCode2();
        ListNode linkedList = leeCode2.addTwoNumbers(node1, node4);
        System.out.println(linkedList);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}