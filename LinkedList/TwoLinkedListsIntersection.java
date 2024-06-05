package dsa.solutions.LinkedList;

public class TwoLinkedListsIntersection {

    public static void main(String[] args) {
        var l1N3 = new ListNode(10);
        var l1N2 = new ListNode(2, l1N3);
        var h1 = new ListNode(1, l1N2);

        var l2N4 = new ListNode(6);
        var l2N3 = new ListNode(5, l2N4);
        var l2N2 = new ListNode(4,l2N3);
        var h2 = new ListNode(3, l2N2);
        l1N3.next = l2N3;
        System.out.println("List-1:");
        ListNodeUtils.displayList(h1);

        System.out.println("List-2:");
        ListNodeUtils.displayList(h2);


        System.out.println("isLLsIntersected: "+isLLsIntersected(h1, h2));

    }

    public static  boolean isLLsIntersected(ListNode h1, ListNode h2){
        if(h1 == null || h2 == null)
            return false;

        var h1Len = findLength(h1);
        var h2Len = findLength(h2);

        if(h1Len > h2Len){
            var diff = h1Len-h2Len;
            while (diff>0){
                h1 = h1.next;
                diff--;
            }
        }else if(h2Len > h1Len){
            var diff = h2Len-h1Len;
            while (diff>0){
                h2 = h2.next;
                diff--;
            }
        }

        while(h1 != null && h2 != null){
            if(h1 == h2){
                System.out.println("Lists Intersected at: "+h1.val);
                return true;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return false;
    }

    private static int findLength(ListNode h1) {
        var temp = h1;
        var len = 0;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}
