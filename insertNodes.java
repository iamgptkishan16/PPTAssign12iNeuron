/*
 
💡 **Question 7**

Given two linked lists, insert nodes of second list into first list at alternate positions of first list.
For example, if first list is 5->7->17->13->11 and second is 12->10->2->4->6, the first list should become 5->12->7->10->17->2->13->4->11->6 and second list should become empty. The nodes of second list should only be inserted when there are positions available. For example, if the first list is 1->2->3 and second list is 4->5->6->7->8, then first list should become 1->4->2->5->3->6 and second list to 7->8.

Use of extra space is not allowed (Not allowed to create additional nodes), i.e., insertion must be done in-place. Expected time complexity is O(n) where n is number of nodes in first list.

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

public class insertNodes {

    public static void insertAtAlternatePositions(ListNode first, ListNode second) {
        if (first == null || second == null) {
            return;
        }

        ListNode firstPtr = first;
        ListNode secondPtr = second;
        ListNode firstNext, secondNext;

        while (firstPtr != null && secondPtr != null) {
            // Save the next pointers for both lists
            firstNext = firstPtr.next;
            secondNext = secondPtr.next;

            // Insert the node from the second list into the first list
            firstPtr.next = secondPtr;
            secondPtr.next = firstNext;

            // Move the pointers to the next positions
            firstPtr = firstNext;
            secondPtr = secondNext;
        }

        // Update the head of the second list to be null (empty)
        second = null;
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
        // Create the first list: 5->7->17->13->11
        ListNode first = new ListNode(5);
        first.next = new ListNode(7);
        first.next.next = new ListNode(17);
        first.next.next.next = new ListNode(13);
        first.next.next.next.next = new ListNode(11);

        // Create the second list: 12->10->2->4->6
        ListNode second = new ListNode(12);
        second.next = new ListNode(10);
        second.next.next = new ListNode(2);
        second.next.next.next = new ListNode(4);
        second.next.next.next.next = new ListNode(6);

        System.out.println("First List:");
        displayList(first);

        System.out.println("Second List:");
        displayList(second);

        insertAtAlternatePositions(first, second);

        System.out.println("Modified First List:");
        displayList(first);

        System.out.println("Modified Second List:");
        displayList(second);
    }
}
