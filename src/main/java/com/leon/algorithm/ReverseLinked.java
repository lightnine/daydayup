package com.leon.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leon
 * @since 2019/7/7 11:18
 * 反转单链表, 采用三种方法
 */
public class ReverseLinked {
    private static final List<String> linkedList = new LinkedList<>();
    static {
        linkedList.add("str1");
        linkedList.add("str2");
        linkedList.add("str3");
        linkedList.add("str4");
        linkedList.add("str5");
        linkedList.add("str6");
        linkedList.add("str7");
    }
    public static List<String> reverse1(List<String> list) {
        String[] array = list.toArray(new String[0]);
        List<String> result = new ArrayList<>();
        for (int i = array.length - 1; i > -1; i--) {
            result.add(array[i]);
        }
        return result;
    }

    /**
     * 为了下面两个方法创建的静态类
     */
    static class Node {
        int value;
        Node next;

        public Node(int data, Node next) {
            this.value = data;
            this.next = next;
        }
    }
    private static Node makeData() {
        // 3->2->1->null
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, node1);
        Node node3 = new Node(3, node2);
        return node3;
    }
    public static Node reverse2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newHead = reverse2(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static Node reverse3(Node node) {
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = next;
            node = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        // method1 test
        System.out.println("方法1结果:");
        System.out.println(ReverseLinked.reverse1(linkedList));
        // method2 test
        System.out.println("方法2结果:");
        Node head = makeData();
        Node newHead = ReverseLinked.reverse2(head);
        while (newHead != null) {
            System.out.print(newHead.value + "->");
            newHead = newHead.next;
        }
        System.out.println();
        // method3 test
        System.out.println("方法3结果:");
        Node anotherHead = makeData();
        Node anotherNewHead = ReverseLinked.reverse2(anotherHead);
        while (anotherNewHead != null) {
            System.out.print(anotherNewHead.value + "->");
            anotherNewHead = anotherNewHead.next;
        }
    }
}
