/*
💡 **Question 3**

Given a linked list consisting of **L** nodes and given a number **N**. The task is to find the **N**th node from the end of the linked list.

**Example 1:**
Input:
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output:8
Explanation:In the first example, there
are 9 nodes in linked list and we need
to find 2nd node from end. 2nd node
from end is 8.


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

public class NthNodeEnd {

    public static ListNode findNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null; // Invalid input, return null
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // Move the fast pointer n nodes ahead
        for (int i = 0; i < n; i++) {
            if (fastPtr == null) {
                return null; // The linked list has less than n nodes, return null
            }
            fastPtr = fastPtr.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fastPtr != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        return slowPtr;
    }

    public static void main(String[] args) {
        // Create the linked list: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2; // Find the 2nd node from the end

        ListNode nthNode = findNthFromEnd(head, n);

        if (nthNode != null) {
            System.out.println("The " + n + "th node from the end is: " + nthNode.val);
        } else {
            System.out.println("Invalid input or the node does not exist.");
        }
    }
}
