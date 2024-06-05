package dsa.solutions.LinkedList;

import static dsa.solutions.LinkedList.ListNodeUtils.*;

public class ListNodeUtilsApp {

    public static void main(String[] args) {
        var node5 = new ListNode(5);
        var node4 = new ListNode(4, node5);
        var node3 = new ListNode(3, node4);
        var node2  = new ListNode(2, node3);
        var head = new ListNode(1, node2);
        int k=3;
        displayList(head);
        System.out.println("Length: "+length(head));
        System.out.println("K Node: "+findKthNode(head, 1).val);
        System.out.println("K Node: "+findKthNode(head, k).val);
        System.out.println("K Node: "+findKthNode(head, 5).val);


    }
}
