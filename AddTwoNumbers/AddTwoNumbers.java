public class AddTwoNumbers {
       public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } 
        if (l2 == null) {
            return l1;
        }
        int digit = 0;
        ListNode head = null;
        ListNode curr = null;
        while((l1 != null) && (l2 != null)) {
            ListNode node = new ListNode((l1.val + l2.val + digit)%10);
            digit = (l1.val + l2.val + digit)/10;
            if (head == null) {
                head = node;
                curr = head;
            } else {
                curr.next = node;
                curr = curr.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            curr.next = l1;
            while (l1 != null) {
                int tmp = l1.val + digit;
                l1.val = tmp%10;
                digit = tmp/10;
                if (digit == 0) {
                    break;
                }
                l1 = l1.next;
                curr = curr.next;
            }

        }

        if (l2 != null) {
            curr.next = l2;
            while( l2!= null) {
                int tmp = l2.val + digit;
                l2.val = tmp%10;
                digit = tmp/10;
                if (digit == 0) {
                    break;
                }
                l2 = l2.next;
                curr = curr.next;
            }
        }
        if (digit == 1) {
            ListNode node = new ListNode(1);
            curr.next = node;
        }
        return head;
    }
}
