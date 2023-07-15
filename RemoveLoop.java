/*

💡 **Question 5**

Given a linked list of **N** nodes such that it may contain a loop.

A loop here means that the last node of the link list is connected to the node at position X(1-based index). If the link list does not have any loop, X=0.

Remove the loop from the linked list, if it is present, i.e. unlink the last node which is forming the loop.

**Example 1:**
Input:
N = 3
value[] = {1,3,4}
X = 2
Output:1
Explanation:The link list looks like
1 -> 3 -> 4
     ^    |
     |____|
A loop is present. If you remove it
successfully, the answer will be 1.


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

public class RemoveLoop {

    public static void removeLoop(ListNode head) {
        if (head == null || head.next == null) {
            return; // Empty list or list with one node does not have a loop
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // Detect the loop using the "fast and slow pointers" technique
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }

        if (!loopExists) {
            return; // No loop found, nothing to remove
        }

        // Move slow pointer back to the head and advance both pointers one step at a time until they meet
        slowPtr = head;
        while (slowPtr.next != fastPtr.next) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        // Unlink the last node to remove the loop
        fastPtr.next = null;
    }

    public static void main(String[] args) {
        // Create a linked list with a loop: 1->2->3->4->5->3 (loop)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next; // Create a loop by connecting the last node to the third node

        removeLoop(head);

        if (!hasLoop(head)) {
            System.out.println("Loop removed successfully.");
        } else {
            System.out.println("Loop not removed.");
        }
    }

    // Function to check if a linked list has a loop (same as Question 2)
    public static boolean hasLoop(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                return true; // Loop detected
            }
        }

        return false; // No loop found
    }
}
