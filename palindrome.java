/*
💡 **Question 4**

Given a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.

**Examples:**
> Input: R->A->D->A->R->NULL
> 
> 
> **Output:** Yes
> 
> **Input:** C->O->D->E->NULL
> 
> **Output:** No
>
 */

package Java_DSA.LinkedList.Assignment12;

class ListNode {
    char val;
    ListNode next;

    ListNode(char val) {
        this.val = val;
        this.next = null;
    }
}

public class palindrome {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Empty list or list with one node is a palindrome
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // Move slowPtr to the middle of the list
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Reverse the second half of the list
        ListNode reversedSecondHalf = reverseList(slowPtr);

        // Compare the reversed second half with the first half of the list
        ListNode p1 = head;
        ListNode p2 = reversedSecondHalf;

        while (p2 != null) {
            if (p1.val != p2.val) {
                return false; // Characters do not match, not a palindrome
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true; // All characters matched, it is a palindrome
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        // Create a palindrome linked list: r->a->d->a->r
        ListNode head = new ListNode('r');
        head.next = new ListNode('a');
        head.next.next = new ListNode('d');
        head.next.next.next = new ListNode('a');
        head.next.next.next.next = new ListNode('r');

        boolean isPalindrome = isPalindrome(head);

        if (isPalindrome) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
