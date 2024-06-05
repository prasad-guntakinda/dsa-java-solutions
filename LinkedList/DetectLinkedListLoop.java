package dsa.solutions.LinkedList;

import java.util.HashSet;

public class DetectLinkedListLoop {

    public static void main(String[] args) {
        var node4 = new ListNode(10);
        var node3 = new ListNode(2, node4);
        var node2 = new ListNode(5, node3);
        var node1 = new ListNode(3, node2);
        var head = new ListNode(1,node1);
        node4.next = node2;

        System.out.println("isLoopExistsHashSet: "+isLoopExistsHashSet(head));
        System.out.println("isLoopExistsFastSlowPointer: "+isLoopExistsFastSlowPointer(head));
        detectAndBreakLoop(head);
        System.out.println("detectAndBreakLoop: ");
        ListNodeUtils.displayList(head);
    }

    public  static boolean isLoopExistsHashSet(ListNode head){
        var set = new HashSet<ListNode>();
        var temp = head;
        while (temp != null){
            if(set.contains(temp)){
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }

    public  static boolean isLoopExistsFastSlowPointer(ListNode head){
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                return true;
        }

        return false;
    }

    public static void detectAndBreakLoop(ListNode head){
        var fast = head;
        var slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                //Loop Exists Need to Break it
                fast = head;
                var prev = slow;
                while (slow != fast){
                    prev = slow;
                    slow = slow.next;
                    fast = fast.next;
                }
                System.out.println("Loop Detected at Node: "+slow.val);
                prev.next = null;
                return;
            }

        }
        System.out.println("Loop Doesnot Exists.");
    }
}
