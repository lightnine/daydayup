package com.leon.leecode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Number21Test {

    @Test
    public void merge124And134() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        Number21 number21 = new Number21();
        ListNode result = number21.mergeTwoLists(l1, l2);
        String resultVal = "";
        while (result.next != null) {
            System.out.println(result.val);
            resultVal = resultVal + result.val;
        }
        Assert.assertEquals("112344", resultVal);
    }
}