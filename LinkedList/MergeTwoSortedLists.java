package dsa.solutions.LinkedList;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        var node2 = new ListNode(3);
        var h1 = new ListNode(2, node2);

        var l2N4 = new ListNode(6);
        var l2N3 = new ListNode(5, l2N4);
        var l2N2 = new ListNode(4,l2N3);
        var h2 = new ListNode(3, l2N2);
        System.out.println("List-1:");
        ListNodeUtils.displayList(h1);

        System.out.println("List-2:");
        ListNodeUtils.displayList(h2);


        System.out.println("Merged List-3:");
        var h3 = mergeSortedList(h1, h2);
        ListNodeUtils.displayList(h3);

    }

    public  static ListNode mergeSortedList(ListNode h1, ListNode h2){
        var h3 = new ListNode(-1); //Dummy Node
        var tail = h3; //Tail Pointer
        while (h1 != null && h2 != null){
            if(h1.val <= h2.val){
                tail.next = h1;
                h1 = h1.next;
            }else {
                tail.next = h2;
                h2 = h2.next;
            }
            tail = tail.next;
        }
        //Corner Case: Appending non-empty list
        if(h1 == null)
            tail.next = h2;
        if(h2 == null)
            tail.next = h1;

        return h3.next;
    }

}
