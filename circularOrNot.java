/*
💡 **Question 8**

Given a singly linked list, find if the linked list is [circular](https://www.geeksforgeeks.org/circular-linked-list/amp/) or not.

> A linked list is called circular if it is not NULL-terminated and all nodes are connected in the form of a cycle. Below is an example of a circular linked list.


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

public class circularOrNot {

    public static boolean isCircular(ListNode head) {
        if (head == null) {
            return false; // Empty list is not circular
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return true; // Loop detected, the list is circular
            }
        }

        return false; // No loop found, the list is not circular
    }

    public static void main(String[] args) {
        // Create a circular linked list: 1->2->3->4->5->2 (loop)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next; // Create a loop by connecting the last node to the second node

        if (isCircular(head)) {
            System.out.println("The linked list is circular.");
        } else {
            System.out.println("The linked list is not circular.");
        }
    }
}
