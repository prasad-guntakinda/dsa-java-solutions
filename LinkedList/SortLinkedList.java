package dsa.solutions.LinkedList;

public class SortLinkedList {
    public static void main(String[] args) {


        System.out.println("Before Sort: ");
        var input1 = input1();
        ListNodeUtils.displayList(input1);

        System.out.println("After Sort: ");
        var res1 = sortList(input1);
        ListNodeUtils.displayList(res1);


        System.out.println("Before Sort: ");
        var input2 = input2();
        ListNodeUtils.displayList(input2);

        System.out.println("After Sort: ");
        var res2 = sortList(input2);
        ListNodeUtils.displayList(res2);

    }



    public  static  ListNode sortList(ListNode head){
        if(head == null || head.next == null)
            return head;
        //Step-1: Divide the Node into 2 parts
        //findMid: by using fast-slow pointer
        var mid = findMidNode(head);
        var h2 = mid.next;
        //disconnect the first part
        mid.next = null;

        head = sortList(head);
        h2 = sortList(h2);

        return mergeSort(head, h2);

    }



    private static ListNode mergeSort(ListNode h1, ListNode h2) {
        var h3 = new ListNode(-1);
        var tail = h3;
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
        if(h1 == null)
            tail.next = h2;
        if(h2 == null)
            tail.next = h1;

        return h3.next;
    }

    public static ListNode findMidNode(ListNode head){
        var fast = head;
        var slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

    public  static ListNode input1(){
        var node2 = new ListNode(1);
        var node1 = new ListNode(0, node2);
        var head = new ListNode(2, node1);
        return head;
    }

    public  static ListNode input2(){
        var node5 = new ListNode(12);
        var node4 = new ListNode(3, node5);
        var node3 = new ListNode(0, node4);
        var node2 = new ListNode(1, node3);
        var node1 = new ListNode(9, node2);
        var head = new ListNode(3, node1);
        return head;
    }



}
