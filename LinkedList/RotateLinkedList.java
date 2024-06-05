package dsa.solutions.LinkedList;

public class RotateLinkedList {

    public static void main(String[] args) {
        var head = ListNodeUtils.createList(8);
        ListNodeUtils.displayList(head);
        int k=2;
        var res = rotateRight(head, k);
        System.out.println("After "+k+"Rotations List: ");
        ListNodeUtils.displayList(res);

    }

    //rotate list for k times towards left
    //make it circular and move head pointer for k times
    public static ListNode rotateLeft(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int len = 1;
        //make LL to Circular
        ListNode temp = head;
        while(temp.next !=null){
            len++;
            temp = temp.next;
        }
        System.out.println("Last Node"+temp.val);
        System.out.println("len: "+len);
        temp.next = head;
        k = k%len;
        ListNode prev = head;
        System.out.println("k: "+k);
        while(k >0){
            prev = head;
            head = head.next;
            k--;
        }

        System.out.println("Prev: "+prev.val);
        System.out.println("head:"+head.val);
        prev.next = null;
        ListNodeUtils.displayList(head);
        return head;
    }

    //Step-1: Convert Linked List to Circular Linked List
    //Step-2: Move Head Pointer n-k times
    //Step-3 break the chain
    public static ListNode rotateRight(ListNode head, int k){
        if(head == null  || head.next == null)
            return head;
        //Step-1: convert LL to CLL
        var temp = head;
        var len = 1;
        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        //making circular
        temp.next = head;
        k = k%len;
        var prev = head;
        // moving head for n-k times
        while((len-k-1)>0){
            prev = prev.next;
            k++;
        }
        //Step-3 Break the chain
        head = prev.next;
        prev.next = null;
        return head;
    }



}


