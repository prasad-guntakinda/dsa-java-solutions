package dsa.solutions.LinkedList;

import java.util.stream.IntStream;

public class ListNodeUtils {

    public static void displayList(ListNode head) {
        var temp = head;
        while (temp != null) {

            if (temp.next != null) {
                System.out.print(temp.val + " => ");
            } else {
                System.out.println(temp.val + " => null");
            }

            temp = temp.next;
        }

    }

    public  static int length(ListNode head){
        int len = 0;
        var temp = head;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        return  len;
    }

    public  static ListNode findKthNode(ListNode head, int k){
        if(length(head) < k)
            throw new RuntimeException("invalid K="+k);

        var res = head;
        // input is  not index based.
        // So first element means it should return head
        while(k-1>0){
            res = res.next;
            k--;
        }

        return res;
    }

    public  static  ListNode createList(int noOfNodes){
        var head = new ListNode(-1);
        ListNode prev = head;
        for(int i=1;i<=noOfNodes;i++){
            var new_node = new ListNode(i);
            prev.next = new_node;
            prev = new_node;
        }
        return head.next;
    }
}
