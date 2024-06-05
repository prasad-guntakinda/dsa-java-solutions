package dsa.solutions.LinkedList;

import static dsa.solutions.LinkedList.ReverseList.reverse;

public class Palindrome {

    public static void main(String[] args) {
        var h1 = ListNodeUtils.createList(3);
        System.out.println("List: ");
        ListNodeUtils.displayList(h1);
        System.out.println("Mid: "+findMid(h1).val);

        var h2 = ListNodeUtils.createList(4);
        System.out.println("List: ");
        ListNodeUtils.displayList(h2);
        System.out.println("Mid: "+findMid(h2).val);

        var h3 = ListNodeUtils.createList(8);
        System.out.println("List: ");
        ListNodeUtils.displayList(h3);
        System.out.println("Mid: "+findMid(h3).val);

    }

    public static boolean isListPalindrome(ListNode head){
        //find the middle node
        var mid = findMid(head);
        //divide into 2 parts
        var h2 = mid.next;
        mid.next = null;
        //reverse part-2
        h2 = reverse(h2);
        //compare both the parts
        while(h2 != null && head.val == h2.val){
            head = head.next;
            h2 = h2.next;
        }

        return h2 == null;

    }

    public static ListNode findMid(ListNode head){
        if(head == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
