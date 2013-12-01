public class SortList {
public ListNode sortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return split(head);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode curr = head;
        while ((l1 != null) && (l2 != null)){
            if (l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            } 
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return head;
    }
    
    private ListNode split(ListNode list){
        int len = listSize(list);
        if (len <= 1) {
            return list;
        }
        ListNode curr = list;
        ListNode left = curr;
        for (int i = 0; i < (len/2 - 1); i++){
            curr = curr.next;
        }
        ListNode right = curr.next;
        curr.next = null;
        left = split(left);
        right = split(right);
        return merge(left, right);
        
    }
    
    private int listSize(ListNode list){
        if (list == null) {
            return 0;
        }
        int count = 0;
        while (list != null) {
            list = list.next;
            count++;
        }
        return count;
    }

}
