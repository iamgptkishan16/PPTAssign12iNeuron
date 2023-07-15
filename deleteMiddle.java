/*
💡 **Question 1**

Given a singly linked list, delete **middle** of the linked list. For example, if given linked list is 1->2->**3**->4->5 then linked list should be modified to 1->2->4->5.If there are **even** nodes, then there would be **two middle** nodes, we need to delete the second middle element. For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.If the input linked list is NULL or has 1 node, then it should return NULL

**Example 1:**

Input:
LinkedList: 1->2->3->4->5
Output:1 2 4 5

*/

package Java_DSA.LinkedList.Assignment12;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class deleteMiddle {

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If the input list is NULL or has 1 node, return NULL
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prevPtr = null;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next; // Fast pointer moves two steps at a time
            prevPtr = slowPtr;
            slowPtr = slowPtr.next; // Slow pointer moves one step at a time
        }

        prevPtr.next = slowPtr.next; // Delete the middle element(s) by updating the next reference of the previous node

        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        printList(head);

        head = deleteMiddle(head);

        System.out.println("Modified list:");
        printList(head);
    }
}
