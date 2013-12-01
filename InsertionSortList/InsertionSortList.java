public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) {
            return null;
        }
        ListNode curr = head.next;
        ListNode prev = head;
        ListNode pos;
        ListNode mov;
        while (curr != null) {
            
            pos = curr.next;
            if (curr.val < head.val) {
                prev.next = pos;
                curr.next = head;
                head = curr;
            } else {
                mov = head;
                while (mov.next != curr) {
                    if (curr.val < mov.next.val) {
                        prev.next = pos;
                        curr.next = mov.next;
                        mov.next = curr;
                        break;
                    }
                    mov = mov.next;
                }
            }
            
            if (prev.next != pos) {
                prev = prev.next;
            }
            curr = pos;
            
        }
        return head;
    }
}
