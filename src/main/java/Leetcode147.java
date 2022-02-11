package main.java;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode node1,node2;
        ListNode pesudohead = new ListNode();
        pesudohead.next = head;


        node1 = pesudohead;
        int n = 0;
        while(node1!=null){
            n++;
            node1 = node1.next;
        }

        node1 = pesudohead;
        ListNode[] nodes = new ListNode[n];
        for(int i=0;i<n;i++){
            nodes[i] = node1;
            node1 = node1.next;
        }

        for(int i=2; i<n; i++){
            int j = i-1;
            node2 = nodes[i];
            nodes[j].next = node2.next;
            while(j>=1 && node2.val<nodes[j].val){
                nodes[j+1] = nodes[j];
                j--;
            }
            if(j+2 < n)
                node2.next = nodes[j+2];
            else
                node2.next = null;
            nodes[j].next = node2;
            nodes[j+1] = node2;
        }
        return nodes[1];
    }
}
