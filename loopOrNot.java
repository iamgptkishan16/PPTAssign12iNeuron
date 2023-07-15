/*
💡 **Question 2**

Given a linked list of **N** nodes. The task is to check if the linked list has a loop. Linked list can contain self loop.

**Example 1:**
Input:
N = 3
value[] = {1,3,4}
x(position at which tail is connected) = 2
Output:True
Explanation:In above test case N = 3.
The linked list with nodes N = 3 is
given. Then value of x=2 is given which
means last node is connected with xth
node of linked list. Therefore, there
exists a loop.

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

public class loopOrNot {

    public static boolean hasLoop(ListNode head) {
        if (head == null) {
            return false; // If the linked list is empty, there is no loop
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next; // Move slow pointer one step at a time
            fastPtr = fastPtr.next.next; // Move fast pointer two steps at a time

            if (slowPtr == fastPtr) {
                return true; // Loop detected
            }
        }

        return false; // No loop found
    }

    public static void main(String[] args) {
        // Create a linked list with a loop: 1->2->3->4->5->3 (loop)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next; // Create a loop by connecting the last node to the third node

        boolean loopExists = hasLoop(head);

        if (loopExists) {
            System.out.println("The linked list has a loop.");
        } else {
            System.out.println("The linked list does not have a loop.");
        }
    }
}
