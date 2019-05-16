package com.shotacon.amazing.leetcode;

public class LeetCode {

    public static void main(String[] args) {
        
        System.out.println(Math.PI);
//        ListNode l1 = new ListNode();
//        int[] l1Array = new int[] { 3, 4, 2 };
//        for (int i = 0; i < l1Array.length; i++) {
//            if (l1.isEmpty) {
//                l1 = new ListNode(l1Array[i]);
//            } else {
//                l1 = insert(l1, l1Array[i]);
//            }
//        }
//        addTwoNumbers(l1, null);
    }

    private static ListNode insert(ListNode o, int val) {
        ListNode l = new ListNode(val);
        l.next = o;
        return l;
    }

    public static class ListNode {
        int val;
        ListNode next;
        boolean isEmpty = true;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            isEmpty = false;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l = l1;
        String l1Str = "";
        while (l.next != null) {
            l1Str = l1Str.concat(String.valueOf(l.val));
            l = l.next;

        }
        String leftStr = "";
        for (int i = l1Str.length() - 1; i >= 0; i--) {
            leftStr.concat(String.valueOf(l1Str.charAt(i)));
        }
        System.out.println(leftStr);

        return null;
    }

    public static int lengthOfLongestSubstring(String s) {
        int finalSize = 0;
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            String t = String.valueOf(s.charAt(i));
            if (temp.contains(t)) {
                temp = temp.substring(temp.indexOf(t) + 1, temp.length()).concat(t);
            } else {
                temp = temp.concat(t);
            }
            finalSize = temp.length() > finalSize ? temp.length() : finalSize;
        }
        return finalSize;
    }
}
