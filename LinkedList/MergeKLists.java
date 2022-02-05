package LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        ListNode head = merge2Lists(lists[0], lists[1]);
        for(int i=2;i<lists.length;i++) {
            head = merge2Lists(head, lists[i]);
        }
        return head;
    }
    
    public ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(0);
        ListNode ans = node;
        
        while(list1!=null && list2!=null) {
            if(list1.val < list2.val) {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            } else {
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            }
        }
        
        while(list1!=null) {
            node.next = list1;
            node = node.next;
            list1 = list1.next;
        }
        
        while(list2!=null) {
            node.next = list2;
            node = node.next;
            list2 = list2.next;
        }
        
        return ans.next;
    }
}
