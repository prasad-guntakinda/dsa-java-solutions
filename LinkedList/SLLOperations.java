package dsa.solutions.LinkedList;

public class SLLOperations {

    public static void main(String[] args) {
        var head = ListNodeUtils.createList(5);
        traverse(head);
        head = insertAtStart(head, new ListNode(100));
        traverse(head);
        head = insertAtEnd(head, new ListNode(1000));
        traverse(head);

        head = insertAtK(head, new ListNode(500), 3);
        traverse(head);


        var head2 = ListNodeUtils.createList(5);


        head2 = deleteAtStart(head2);
        traverse(head2);

        head2 = deleteAtEnd(head2);
        traverse(head2);

        head2 = deleteAtK(head2, 2);
        traverse(head2);
    }

    public static void traverse(ListNode head){
        var temp = head;
        while(temp != null){
            System.out.print(temp.val+" --> ");
            temp = temp.next;
        }
        System.out.println();

    }

    public  static ListNode insertAtStart(ListNode head, ListNode new_node){
        if(head == null)
            return new_node;

        new_node.next = head;
        head = new_node;
        return head;
    }

    public  static ListNode insertAtEnd(ListNode head, ListNode new_node){
        if(head == null)
            return new_node;

        var temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new_node;
        return head;
    }
    //Assumption: index starts from 0
    public  static ListNode insertAtK(ListNode head, ListNode new_node, int pos){
        if(pos == 0)
            return  insertAtStart(head,new_node);
        var temp = head;

        while(temp != null && (pos-1)>0){
            temp = temp.next;
            pos--;
        }
        if(pos <0){
            throw new IllegalArgumentException("Invalid Position has given");
        }
        var next_node = temp.next;
        temp.next = new_node;
        new_node.next = next_node;
        return head;
    }


    public static ListNode deleteAtStart(ListNode head){
        if(head !=null){
            return head.next;
        }

        return head;
    }

    public static ListNode deleteAtEnd(ListNode head){
        if(head == null || head.next ==null)
            return null;

        var temp = head;

        while(temp.next != null && temp.next.next !=null){
            temp = temp.next;
        }

        temp.next = null;
        return head;

    }

    public  static ListNode deleteAtK(ListNode head, int pos){
        if(pos == 0)
            return deleteAtStart(head);
        var temp = head;
        while(temp != null && (pos-1)>0){
            temp = temp.next;
            pos--;
        }
        if(pos < 0){
            throw  new IllegalArgumentException("Invalid Position has given");
        }

        var del_node = temp.next;
        temp.next = temp.next.next;
        del_node.next = null;
        return  head;
    }

}
