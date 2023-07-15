/*
💡 **Question 6**

Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes, continue the same till end of the linked list.

Difficulty Level: Rookie

**Examples**:
Input:
M = 2, N = 2
Linked List: 1->2->3->4->5->6->7->8
Output:
Linked List: 1->2->5->6

Input:
M = 3, N = 2
Linked List: 1->2->3->4->5->6->7->8->9->10
Output:
Linked List: 1->2->3->6->7->8

Input:
M = 1, N = 1
Linked List: 1->2->3->4->5->6->7->8->9->10
Output:
Linked List: 1->3->5->7->9

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

public class TraverseLL {

    public static ListNode deleteNodes(ListNode head, int M, int N) {
        if (head == null || M <= 0 || N <= 0) {
            return head; // Invalid input, return the original list
        }

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            // Traverse M nodes
            for (int i = 0; i < M && current != null; i++) {
                previous = current;
                current = current.next;
            }

            // Delete N nodes
            for (int i = 0; i < N && current != null; i++) {
                current = current.next;
            }

            // Link the previous node to the next node after deleting N nodes
            previous.next = current;
        }

        return head;
    }

    public static void displayList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list: 1->2->3->4->5->6->7->8->9->10
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        int M = 2;
        int N = 3;

        System.out.println("Original Linked List:");
        displayList(head);

        ListNode modifiedList = deleteNodes(head, M, N);

        System.out.println("Modified Linked List:");
        displayList(modifiedList);
    }
}
