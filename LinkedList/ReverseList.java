package dsa.solutions.LinkedList;

public class ReverseList {
    public static void main(String[] args) {
        var head = ListNodeUtils.createList(5);
        System.out.print("Before Reverse: ");
        ListNodeUtils.displayList(head);
        head = reverse(head);
        System.out.print("After Reverse: ");
        ListNodeUtils.displayList(head);
    }

    public  static ListNode reverse(ListNode head){
        ListNode prev = null;
        var curr = head;
        while(curr !=null){
            var temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head = prev;
        return head;
    }
}
